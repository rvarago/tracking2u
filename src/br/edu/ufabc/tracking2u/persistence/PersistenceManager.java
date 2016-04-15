package br.edu.ufabc.tracking2u.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import br.edu.ufabc.tracking2u.entity.Entidade;

/**
 * Gerenciador de CRUD, inspirado no EntityManager do Hibernate.
 *
 * @author rvarago
 */
public interface PersistenceManager {
	public <E extends Entidade> void save(E entity) throws FileNotFoundException, IOException;

	public <E extends Entidade> void delete(E entity);

	public <E extends Entidade> void update(E entity) throws FileNotFoundException, IOException;

	public <E extends Entidade> E find(Long id, Class<E> clazz)
			throws ClassNotFoundException, FileNotFoundException, IOException;

	public <E extends Entidade> List<? super E> list(Class<? extends E> clazz)
			throws FileNotFoundException, IOException, ClassNotFoundException;
}
