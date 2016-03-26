package br.edu.ufabc.tracking2u.dao;

import java.util.Collection;

/**
 * @author rvarago
 */
public interface Responsavel {
	public void adicionarPapel(Papel papel);

	public Collection<Papel> listarPapeis();
}
