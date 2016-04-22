package br.edu.ufabc.tracking2u.persistence;

/**
 * @author rvarago
 */
public class PersistenceManagerFactory {
	private static final String DEFAULT_ENTITY_PATH = "entidades/";
	private static final PersistenceManager manager = new PersistenceManagerImpl(DEFAULT_ENTITY_PATH);

	public static PersistenceManager buildPersistenceManager() {
		return manager;
	}
}
