package br.edu.ufabc.tracking2u.entity;

import java.util.Collection;
import java.util.List;

/**
 * @author rvarago
 */
public interface Responsavel {
	public void adicionarPapel(List<Papel> papel);

	public Collection<Papel> listarPapeis();

}
