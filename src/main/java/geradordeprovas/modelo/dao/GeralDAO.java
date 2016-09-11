package geradordeprovas.modelo.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class GeralDAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public GeralDAO() {

	}

	public GeralDAO(EntityManager manager) {
		this.manager = manager;
	}

	public T inserir(T entity) {
		manager.persist(entity);
		return entity;
	}

	public T salvar(T entity) {
		manager.merge(entity);
		return entity;
	}

	public void remover(T entity) {
		manager.remove(entity);
	}
}
