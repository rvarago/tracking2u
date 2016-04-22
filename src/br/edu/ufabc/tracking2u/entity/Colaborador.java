package br.edu.ufabc.tracking2u.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author rvarago
 */
public class Colaborador extends Entidade implements Responsavel {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String senha;

	private List<Papel> papeis = new ArrayList<>();
	private List<Tarefa> tarefas = new ArrayList<>();
	private List<Pendencia> pendencias = new ArrayList<>();

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

	public List<Tarefa> getTarefas() {
		return this.tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<Pendencia> getPendencias() {
		return this.pendencias;
	}

	public void setPendencias(List<Pendencia> pendencias) {
		this.pendencias = pendencias;
	}

	@Override
	public void adicionarPapel(List<Papel> papeis) {
		this.papeis = papeis;

	}

	@Override
	public Collection<Papel> listarPapeis() {
		return this.papeis;
	}

}
