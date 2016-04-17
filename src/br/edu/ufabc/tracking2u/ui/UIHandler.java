package br.edu.ufabc.tracking2u.ui;

import java.util.Date;
import java.util.List;

import br.edu.ufabc.tracking2u.entity.Colaborador;
import br.edu.ufabc.tracking2u.entity.Papel;
import br.edu.ufabc.tracking2u.entity.Pendencia;
import br.edu.ufabc.tracking2u.entity.StatusTarefa;
import br.edu.ufabc.tracking2u.entity.Tarefa;

/**
 * Especificação do controlador de tela.
 *
 * @author rvarago
 */
public interface UIHandler {
	public void createColaborador(String nome, String senha, List<Long> codigoPapeis);

	/**
	 * Cria uma {@link Tarefa}
	 *
	 * @param nome
	 *            nome da {@link Tarefa}
	 * @param descricao
	 *            breve descrição da tarefa a ser desenvolvida
	 * 
	 * @param dataPrometida
	 *            data da previsão de finalização da tarefa
	 * @param criadorId
	 *            responsável pela criação, deve ser um colaborador com o
	 *            {@link Papel#GERENTE_PROJETO}.
	 * @throws IllegalArgumentException
	 *             caso o criador não possua a permissão necessária
	 */
	public void createTarefa(String nome, String descricao, Long dataPrometida, Long criadorId)
			throws IllegalArgumentException;

	/**
	 * Atualiza informações da {@link Tarefa}
	 *
	 * @param tarefaId
	 *            {@link Tarefa} a ser atualizada
	 * 
	 * @param horasEsforco
	 *            quantidade de horas trabalhadas ate o momento
	 * @param responsavelAtualId
	 *            identificado do novo {@link Colaborador}
	 * @param statusAtual
	 *            Novo status {@link StatusTarefa}
	 * @throws IllegalArgumentException
	 *             caso o {@link Colaborador} definido por
	 *             <code>responsavelId</code> não possua {@link Papel}
	 *             compatível com o {@link StatusTarefa} definido por
	 *             <code>codigoStatusAtual</code>
	 */
	public void updateTarefa(Long tarefaId, Integer horasEsforco, Long responsavelAtualId, StatusTarefa statusAtual)
			throws IllegalArgumentException;

	/**
	 * Cria nova {@link Pendencia}
	 *
	 * @param nome
	 *            nome da nova {@link Pendencia}
	 * @param descricao
	 *            decrição completa da {@link Pendencia}
	 * @param criadorId
	 *            identificador do {@link Colaborador} pela criação
	 * @param tarefaAssociadaId
	 *            toda a {@link Pendencia} tem uma {@link Tarefa} associada
	 */
	public void createPendencia(String nome, String descricao, Long criadorId, Long tarefaAssociadaId);

	/**
	 * Finaliza uma {@link Pendencia}
	 *
	 * @param pendenciaId
	 *            identificador da {@link Pendencia} a ser finalizada
	 * @param responsavelId
	 *            {@link Colaborador} pela finalização da {@link Pendencia}
	 */
	public void closePendencia(Long pendenciaId, Long responsavelId);

	/**
	 * Lista todas as {@link Tarefa}s e suas {@link Pendencia}s associadas
	 *
	 * @param colaboradorId
	 * @throws IllegalAccessException
	 *             caso o {@link Colaborador} definido por
	 *             <code>colaboradorId</code> não possua o {@link Papel#CLIENTE}
	 */
	public void listarTarefasPendencias(Long colaboradorId) throws IllegalAccessException;

}
