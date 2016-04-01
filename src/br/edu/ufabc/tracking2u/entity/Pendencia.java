package br.edu.ufabc.tracking2u.entity;

/**
 * @author rvarago
 */
public class Pendencia extends ItemEsforco {

	private static final long serialVersionUID = 1L;

	private boolean finalizada;
	private Colaborador criador;
	private Colaborador responsavel;

	public boolean isFinalizada() {
		return this.finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	public Colaborador getCriador() {
		return this.criador;
	}

	public void setCriador(Colaborador criador) {
		this.criador = criador;
	}

	public Colaborador getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(Colaborador responsavel) {
		this.responsavel = responsavel;
	}

}
