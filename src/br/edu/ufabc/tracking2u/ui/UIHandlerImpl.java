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
import java.util.logging.Level;
import java.util.logging.Logger;

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
				JOptionPane.showMessageDialog(null, "Erro na atualizacao do colaborador");

			}

		}
	}

	@Override
	public void manageTarefa(String nome, String descricao, Long dataPrometida, Colaborador colaborador,
			Tarefa tarefaUpdate) throws IllegalArgumentException {
		Tarefa tarefa = new Tarefa();
		tarefa.setNome(nome);
		tarefa.setDescricao(descricao);
		tarefa.setDataPrometida(dataPrometida);

		if (tarefaUpdate == null) {
			tarefa.setCriador(colaborador);
			tarefa.setDataCriacao(System.currentTimeMillis());
			tarefa.setStatus(StatusTarefa.AGUARDANDO_ANALISE);
			this.persist(tarefa);

			JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso");

		} else {
			tarefa.setCriador(tarefaUpdate.getCriador());
			tarefa.setDataCriacao(tarefaUpdate.getDataCriacao());
			tarefa.setStatus(tarefaUpdate.getStatus());
			this.manager.delete(tarefaUpdate);
			try {
				this.manager.save(tarefa);
			} catch (IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Tarefa atualizada com sucesso");

		}

	}

	@Override
	public void updateTarefa(Long tarefaId, Integer horasEsforco, Long responsavelAtualId, StatusTarefa statusAtual)
			throws IllegalArgumentException {
		Tarefa tarefa;
		Colaborador responsavelAtual;
		try {
			tarefa = this.manager.find(tarefaId, Tarefa.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Tarefa com ID " + tarefaId + "nao encontrada");
		}
		try {
			responsavelAtual = this.manager.find(responsavelAtualId, Colaborador.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Colaborador com ID " + responsavelAtualId + "nao encontrado");
		}

		// se a lista de papeis for formada somente pela permissão Cliente, o
		// colaborador não poderá atribuir tarefas
		if (responsavelAtual.getPapel() == Papel.CLIENTE) {
			throw new IllegalArgumentException(
					"Nao e possivel atribuir tarefas a outros colaboradores quando se tem o nivel de acesso "
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
	public void managePendencia(boolean status, String nome, String descricao, Long criadorId, Long tarefaAssociadaId, Pendencia p) {
		Tarefa tarefa;
		Colaborador criador;

		try {
			tarefa = this.manager.find(tarefaAssociadaId, Tarefa.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Tarefa com ID " + tarefaAssociadaId + "nao encontrada");
		}
		try {
			criador = this.manager.find(criadorId, Colaborador.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Colaborador com ID " + criadorId + "nao encontrado");
		}
		Pendencia pendencia = new Pendencia();
		pendencia.setNome(nome);
		pendencia.setDescricao(descricao);
		if (p == null) {
			pendencia.setTarefa(tarefa);
			pendencia.setDataCriacao(System.currentTimeMillis());
			pendencia.setCriador(criador);
			pendencia.setResponsavel(criador);
			this.persist(pendencia);
			JOptionPane.showMessageDialog(null, "Pendencia cadastrada com sucesso");
		} else {
			pendencia.setTarefa(p.getTarefa());
			pendencia.setDataCriacao(p.getDataCriacao());
			pendencia.setCriador(p.getCriador());
			pendencia.setResponsavel(p.getResponsavel());
                        pendencia.setFinalizada(status);

			this.manager.delete(p);
			try {
				this.manager.save(pendencia);

			} catch (IOException ex) {
				Logger.getLogger(UIHandlerImpl.class.getName()).log(Level.SEVERE, null, ex);
			}
			JOptionPane.showMessageDialog(null, "Tarefa atualizada com sucesso");

		}
	}

	@Override
	public void closePendencia(Long pendenciaId, Long responsavelId) {
		Pendencia pendencia;
		Colaborador responsavel;
		try {
			pendencia = this.manager.find(pendenciaId, Pendencia.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Pendencia com ID " + pendenciaId + "nao encontrada");
		}
		try {
			responsavel = this.manager.find(responsavelId, Colaborador.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Colaborador com ID " + responsavelId + "nao encontrado");
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
			throw new IllegalAccessException("Colaborador sem a permissão de " + Papel.CLIENTE + "necessaria");
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
