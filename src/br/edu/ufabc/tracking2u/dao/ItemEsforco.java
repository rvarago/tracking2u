package br.edu.ufabc.tracking2u.dao;

/**
 * @author rvarago
 */
public abstract class ItemEsforco extends Entidade {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Long dataCriacao;
	private Long dataFinalizacao;
	private String descricao;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Long dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Long getDataFinalizacao() {
		return this.dataFinalizacao;
	}

	public void setDataFinalizacao(Long dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
