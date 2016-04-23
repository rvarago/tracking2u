package br.edu.ufabc.tracking2u.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rvarago
 */
public class Colaborador extends Entidade implements Responsavel {

	private static final long serialVersionUID = 1L;

	private String nome;
	private char[] senha;
	private Papel papel;
	
	private List<Tarefa> tarefas = new ArrayList<>();
	private List<Pendencia> pendencias = new ArrayList<>();

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char[] getSenha() {
		return this.senha;
	}

	public void setSenha(char[] senha) {
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

	public Papel getPapel() {
		return this.papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}


}
