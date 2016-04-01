package br.edu.ufabc.tracking2u.entity;

import java.util.Collection;

/**
 * @author rvarago
 */
public interface Responsavel {
	public void adicionarPapel(Papel papel);

	public Collection<Papel> listarPapeis();
}
