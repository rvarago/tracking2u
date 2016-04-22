package br.edu.ufabc.tracking2u.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufabc.tracking2u.entity.Entidade;

/**
 * @author rvarago
 */
public class PersistenceManagerImpl implements PersistenceManager {

	private final String baseFilePath;

	/**
	 * Para esta versão, os IDs são sobrescritos a cada inicialização do sistema
	 */
	private Long ID_SEQUENCE;

	protected PersistenceManagerImpl(String path) {
		this.baseFilePath = path;
		this.ID_SEQUENCE = 1L;
		for (String fileName : new File(this.baseFilePath).list()) {
			int startId = fileName.indexOf("_");
			int endId = fileName.indexOf("\\.");
			try {
				Long currentId = Long.valueOf(fileName.substring(startId, endId));
				if (currentId > this.ID_SEQUENCE) {
					this.ID_SEQUENCE = currentId;
				}
			} catch (Exception e) {
				continue;
			}
		}
	}

	@Override
	public <E extends Entidade> void save(E entity) throws RuntimeException, FileNotFoundException, IOException {
		entity.setId(this.ID_SEQUENCE++);
		String fileName = this.filePath(entity.getClass().getSimpleName(), entity.getId());
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName))) {
			writer.writeObject(entity);
		}
	}

	@Override
	public void delete(Entidade entity) throws RuntimeException {
		new File(this.filePath(entity.getClass().getSimpleName(), entity.getId())).delete();
	}

	@Override
	public void update(Entidade entity) throws RuntimeException, FileNotFoundException, IOException {
		this.delete(entity);
		this.save(entity);
	}

	@Override
	public <E extends Entidade> E find(Long id, Class<E> clazz)
			throws RuntimeException, ClassNotFoundException, FileNotFoundException, IOException {
		String fileName = this.filePath(clazz.getSimpleName(), id);
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName))) {
			return clazz.cast(reader.readObject());
		}
	}

	@Override
	public <E extends Entidade> List<? super Entidade> list(Class<? extends E> clazz)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		List<? super Entidade> entities = new ArrayList<>();
		for (String fileName : new File(this.baseFilePath).list()) {
			try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(this.baseFilePath + fileName))) {
				Object o = reader.readObject();
				if (o.getClass().isAssignableFrom(clazz)) {
					entities.add(clazz.cast(o));
				}
			}
		}
		return entities;
	}

	private String filePath(String entityName, Long id) {
		return this.baseFilePath + entityName + "_" + id + ".ser";
	}

}