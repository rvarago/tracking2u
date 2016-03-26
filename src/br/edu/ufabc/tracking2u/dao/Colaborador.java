package br.edu.ufabc.tracking2u.dao;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author rvarago
 */
public class Colaborador extends Entidade implements Responsavel {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String senha;

	private Collection<Papel> papeis = new HashSet<>();
	private Collection<Tarefa> tarefas = new HashSet<>();

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Collection<Tarefa> getTarefas() {
		return this.tarefas;
	}

	public void setTarefas(Collection<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public void adicionarPapel(Papel papel) {
		this.papeis.add(papel);

	}

	@Override
	public Collection<Papel> listarPapeis() {
		return this.papeis;
	}

}
