package br.edu.ufabc.tracking2u.dao;

/**
 * @author rvarago
 */
public class Tarefa extends ItemEsforco {

	private static final long serialVersionUID = 1L;

	private Long dataPrometida;
	private Integer horasEsforco;
	private StatusTarefa status;
	private Colaborador criador;
	private Colaborador responsavel;

	public Long getDataPrometida() {
		return this.dataPrometida;
	}

	public void setDataPrometida(Long dataPrometida) {
		this.dataPrometida = dataPrometida;
	}

	public Integer getHorasEsforco() {
		return this.horasEsforco;
	}

	public void setHorasEsforco(Integer horasEsforco) {
		this.horasEsforco = horasEsforco;
	}

	public StatusTarefa getStatus() {
		return this.status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
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
