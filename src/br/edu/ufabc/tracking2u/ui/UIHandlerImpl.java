package br.edu.ufabc.tracking2u.ui;

import java.io.IOException;
import javax.swing.JOptionPane;

import br.edu.ufabc.tracking2u.entity.Colaborador;
import br.edu.ufabc.tracking2u.entity.Entidade;
import br.edu.ufabc.tracking2u.entity.Papel;
import br.edu.ufabc.tracking2u.entity.Pendencia;
import br.edu.ufabc.tracking2u.entity.StatusTarefa;
import br.edu.ufabc.tracking2u.entity.Tarefa;
import br.edu.ufabc.tracking2u.persistence.PersistenceManager;
import br.edu.ufabc.tracking2u.persistence.PersistenceManagerFactory;

/**
 * Implementação padrão de {@link UIHandler}. Representa o controlador de tela.
 *
 * @author rvarago
 * @author tuliocarreira
 *
 */
public class UIHandlerImpl implements UIHandler {

	private final PersistenceManager manager = PersistenceManagerFactory.buildPersistenceManager();

	@Override
	public void manageColaborador(String nome, char[] senha, Papel papel, Colaborador c) {
		Colaborador colaborador = new Colaborador();
		colaborador.setNome(nome);
		colaborador.setSenha(senha);
		colaborador.setPapel(papel);
		if (c == null) {
			this.persist(colaborador);
			JOptionPane.showMessageDialog(null, "Colaborador cadastrado com sucesso");
		} else {
			try {
				this.manager.delete(c);
				this.manager.save(colaborador);
				JOptionPane.showMessageDialog(null, "Colaborador atualizado com sucesso");

			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Erro na atualização do colaborador");

			}

		}
	}

	@Override
	public void createTarefa(String nome, String descricao, Long dataPrometida, Long criadorId)
			throws IllegalArgumentException {
		Colaborador colaborador = new Colaborador();
		try {
			colaborador = this.manager.find(criadorId, Colaborador.class);
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(null, "Colaborador com ID " + criadorId + " não encontrado");
		}
		if (colaborador.getPapel() != Papel.GERENTE_PROJETO) {
			JOptionPane.showMessageDialog(null, "Colaborador com ID " + criadorId + " não possui o Papel "
					+ Papel.GERENTE_PROJETO + " necessário para criar a tarefa");

		}
		Tarefa tarefa = new Tarefa();
		tarefa.setNome(nome);
		tarefa.setDescricao(descricao);
		tarefa.setStatus(StatusTarefa.AGUARDANDO_ANALISE);
		tarefa.setResponsavel(colaborador);
		tarefa.setCriador(colaborador);
		tarefa.setDataPrometida(dataPrometida);
		tarefa.setDataCriacao(System.currentTimeMillis());

		this.persist(tarefa);
	}

	@Override
	public void updateTarefa(Long tarefaId, Integer horasEsforco, Long responsavelAtualId, StatusTarefa statusAtual)
			throws IllegalArgumentException {
		Tarefa tarefa;
		Colaborador responsavelAtual;
		try {
			tarefa = this.manager.find(tarefaId, Tarefa.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Tarefa com ID " + tarefaId + "não encontrada");
		}
		try {
			responsavelAtual = this.manager.find(responsavelAtualId, Colaborador.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Colaborador com ID " + responsavelAtualId + "não encontrado");
		}

		// se a lista de papeis for formada somente pela permissão Cliente, o
		// colaborador não poderá atribuir tarefas
		if (responsavelAtual.getPapel() == Papel.CLIENTE) {
			throw new IllegalArgumentException(
					"Não é possível atribuir tarefas a outros colaboradores quando se tem o nível de acesso "
							+ Papel.CLIENTE);
		}
		tarefa.setStatus(statusAtual);
		tarefa.setHorasEsforco(horasEsforco);
		tarefa.setResponsavel(responsavelAtual);
		try {
			this.manager.update(tarefa);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createPendencia(String nome, String descricao, Long criadorId, Long tarefaAssociadaId) {
		Tarefa tarefa;
		Colaborador criador;
		try {
			tarefa = this.manager.find(tarefaAssociadaId, Tarefa.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Tarefa com ID " + tarefaAssociadaId + "não encontrada");
		}
		try {
			criador = this.manager.find(criadorId, Colaborador.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Colaborador com ID " + criadorId + "não encontrado");
		}
		Pendencia pendencia = new Pendencia();
		pendencia.setTarefa(tarefa);
		pendencia.setNome(nome);
		pendencia.setDescricao(descricao);
		pendencia.setDataCriacao(System.currentTimeMillis());
		pendencia.setCriador(criador);
		pendencia.setResponsavel(criador);
		pendencia.setFinalizada(false);
		this.persist(pendencia);
	}

	@Override
	public void closePendencia(Long pendenciaId, Long responsavelId) {
		Pendencia pendencia;
		Colaborador responsavel;
		try {
			pendencia = this.manager.find(pendenciaId, Pendencia.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Pendência com ID " + pendenciaId + "não encontrada");
		}
		try {
			responsavel = this.manager.find(responsavelId, Colaborador.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Colaborador com ID " + responsavelId + "não encontrado");
		}

		pendencia.setFinalizada(true);
		pendencia.setDataFinalizacao(System.currentTimeMillis());
		pendencia.setResponsavel(responsavel);
		try {
			this.manager.update(pendencia);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void listarTarefasPendencias(Long colaboradorId) throws IllegalAccessException {
		Colaborador colaborador;
		try {
			colaborador = this.manager.find(colaboradorId, Colaborador.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Colaborador com ID " + colaboradorId + "não encontrado");
		}
		if (colaborador.getPapel() != Papel.CLIENTE) {
			throw new IllegalAccessException("Colaborador sem a permissão de " + Papel.CLIENTE + "necessária");
		}
		try {
			this.manager.list(Tarefa.class);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	private <T extends Entidade> void persist(T entity) {
		try {
			this.manager.save(entity);
		} catch (IOException e) {
			throw new RuntimeException("Erro ao salvar entidade " + entity.getClass().getSimpleName() + "\n" + e);
		}
	}
}
