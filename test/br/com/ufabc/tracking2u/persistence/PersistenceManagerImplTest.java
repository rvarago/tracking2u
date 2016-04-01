package br.com.ufabc.tracking2u.persistence;

import static java.util.Arrays.asList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.ufabc.tracking2u.entity.Colaborador;
import br.edu.ufabc.tracking2u.entity.Pendencia;
import br.edu.ufabc.tracking2u.entity.StatusTarefa;
import br.edu.ufabc.tracking2u.entity.Tarefa;
import br.edu.ufabc.tracking2u.persistence.PersistenceManager;
import br.edu.ufabc.tracking2u.persistence.PersistenceManagerImpl;

/**
 * @author rvarago
 */
public class PersistenceManagerImplTest {

	private PersistenceManager manager = new PersistenceManagerImpl("entidades/");

	@Test
	public void saveFind() throws FileNotFoundException, IOException, ClassNotFoundException {
		Pendencia pendencia = new Pendencia();
		pendencia.setId(1L);
		pendencia.setNome("Pendência 1");

		Tarefa tarefa = new Tarefa();
		tarefa.setId(1L);
		tarefa.setNome("Tarefa 1");
		tarefa.setDescricao("Descrição da Tarefa 1");
		tarefa.setStatus(StatusTarefa.EM_ANLISE);
		tarefa.setPendencias(asList(pendencia));

		Colaborador colaborador = new Colaborador();
		colaborador.setId(1L);
		colaborador.setNome("Colaborador 1");
		colaborador.setSenha("Senha do Colaborador 1");
		colaborador.setTarefas(asList(tarefa));

		this.manager.save(colaborador);

		Colaborador colaboradorLoaded = this.manager.find(1L, Colaborador.class);

		Assert.assertEquals(colaborador.getId(), colaboradorLoaded.getId());
		Assert.assertEquals(colaborador.getNome(), colaboradorLoaded.getNome());
		Assert.assertEquals(colaborador.getSenha(), colaboradorLoaded.getSenha());

		Tarefa tarefaLoaded = colaborador.getTarefas().get(0);
		Assert.assertEquals(tarefa.getId(), tarefaLoaded.getId());
		Assert.assertEquals(tarefa.getNome(), tarefaLoaded.getNome());
		Assert.assertEquals(tarefa.getDescricao(), tarefaLoaded.getDescricao());
		Assert.assertEquals(tarefa.getStatus(), tarefaLoaded.getStatus());

		Pendencia pendenciaLoaded = tarefaLoaded.getPendencias().get(0);
		Assert.assertEquals(pendencia.getId(), pendenciaLoaded.getId());
		Assert.assertEquals(pendencia.getNome(), pendenciaLoaded.getNome());
	}

	@Test
	public void list() throws FileNotFoundException, IOException, ClassNotFoundException {
		Colaborador colaborador1 = new Colaborador();
		colaborador1.setId(1L);

		Colaborador colaborador2 = new Colaborador();
		colaborador2.setId(2L);

		this.manager.save(colaborador1);
		this.manager.save(colaborador2);

		List<? super Colaborador> colaboradores = this.manager.list(Colaborador.class);

		Assert.assertEquals(colaborador1, colaboradores.get(1));
		Assert.assertEquals(colaborador2, colaboradores.get(0));
	}
}