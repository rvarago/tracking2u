package br.edu.ufabc.tracking2u.entity;

import java.util.List;

/**
 * @author rvarago
 */
public class Tarefa extends ItemEsforco {

	private static final long serialVersionUID = 1L;

	private Long dataPrometida;
	private Integer horasEsforco;
	private StatusTarefa status;

	private List<Pendencia> pendencias;

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

	public List<Pendencia> getPendencias() {
		return this.pendencias;
	}

	public void setPendencias(List<Pendencia> pendencias) {
		this.pendencias = pendencias;
	}

}
