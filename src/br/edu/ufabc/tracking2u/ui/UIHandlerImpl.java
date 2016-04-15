package br.edu.ufabc.tracking2u.ui;

import java.io.IOException;
import java.util.List;

import br.edu.ufabc.tracking2u.entity.Colaborador;
import br.edu.ufabc.tracking2u.entity.Entidade;
import br.edu.ufabc.tracking2u.entity.Papel;
import br.edu.ufabc.tracking2u.entity.Tarefa;
import br.edu.ufabc.tracking2u.persistence.PersistenceManager;
import br.edu.ufabc.tracking2u.persistence.PersistenceManagerImpl;

/**
 * Implementação padrão de {@link UIHandler}. Representa o controlador de tela.
 *
 * @author rvarago
 *
 */
public class UIHandlerImpl implements UIHandler {

	private final PersistenceManager manager = new PersistenceManagerImpl("entidades/");

	@Override
	public void createColaborador(String nome, String senha, List<Long> codigoPapeis) {
		Colaborador colaborador = new Colaborador();
		colaborador.setNome(nome);
		colaborador.setSenha(senha);
		for (Long codigoPapel : codigoPapeis) {
			colaborador.adicionarPapel(Papel.valueOf(codigoPapel));
		}
		this.persist(colaborador);
	}

	@Override
	public void createTarefa(String nome, String descricao, Long criadorId) throws IllegalArgumentException {
		Colaborador colaborador;
		try {
			colaborador = this.manager.find(criadorId, Colaborador.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Colaborador com ID = " + criadorId + " não encontrado");
		}
		if (!colaborador.listarPapeis().contains(Papel.GERENTE_PROJETO)) {
			throw new IllegalArgumentException("Colaborador com ID = " + criadorId + " não possuí o Papel " + Papel.GERENTE_PROJETO
					+ " necessário para criar a tarefa");
		}
		Tarefa tarefa = new Tarefa();
		tarefa.setNome(nome);
		tarefa.setDescricao(descricao);
		tarefa.setCriador(colaborador);
		tarefa.setDataCriacao(System.currentTimeMillis());
		this.persist(colaborador);
	}

	@Override
	public void updateTarefa(Long tarefaId, Long responsavelAtualId, Long codidoStatusAtual) throws IllegalArgumentException {
		// TODO
	}

	@Override
	public void createPendencia(String nome, String descricao, Long criadorId, Long tarefaAssociadaId) {
		// TODO

	}

	@Override
	public void closePendencia(Long pendenciaId, Long responsavelId) {
		// TODO

	}

	@Override
	public void listarTarefasPendencias(Long colaboradorId) throws IllegalAccessException {
		// TODO

	}

	private <T extends Entidade> void persist(T entity) {
		try {
			this.manager.save(entity);
		} catch (IOException e) {
			throw new RuntimeException("Erro ao salvar entidade " + entity.getClass().getSimpleName() + "\n" + e);
		}
	}
}
