package br.edu.ufabc.tracking2u.dao;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author rvarago
 */
public abstract class Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Entidade)) {
			return false;
		}
		return Objects.equals(this.id, ((Entidade) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
}
