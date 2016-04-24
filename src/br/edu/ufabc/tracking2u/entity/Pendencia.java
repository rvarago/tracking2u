package br.edu.ufabc.tracking2u.entity;

/**
 * @author rvarago
 */
public class Pendencia extends ItemEsforco {

	private static final long serialVersionUID = 1L;

	private boolean finalizada;

	private Tarefa tarefa;

	public boolean isFinalizada() {
		return this.finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	public Tarefa getTarefa() {
		return this.tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
        
        
}
