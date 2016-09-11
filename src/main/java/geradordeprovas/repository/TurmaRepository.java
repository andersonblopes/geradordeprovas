package geradordeprovas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import geradordeprovas.modelo.Turma;

public class TurmaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public TurmaRepository() {

	}

	public TurmaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Turma obterPorID(Integer pkturma) {
		return manager.find(Turma.class, pkturma);
	}

	public List<Turma> listarTodos() {
		return manager.createQuery("from Turma order by pkturma desc", Turma.class).getResultList();
	}

	public List<Turma> buscarPorDescricao(String campo, String value) {
		return manager.createQuery("from Turma where " + campo + " like :value order by turma", Turma.class)
				.setParameter("value", "%" + value.toUpperCase() + "%").getResultList();
	}

	public List<Turma> buscarPorRelacionamento(String campo, Object value) {
		return manager.createQuery("from Turma where " + campo + " = :value order by turma", Turma.class)
				.setParameter("value", value).getResultList();
	}

}
