package geradordeprovas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import geradordeprovas.modelo.Professor;

public class ProfessorRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public ProfessorRepository() {

	}

	public ProfessorRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Professor obterPorID(Integer pk) {
		return manager.find(Professor.class, pk);
	}

	public Professor guardar(Professor entity) {
		return manager.merge(entity);
	}

	public void remover(Professor entity) {
		manager.remove(manager.getReference(Professor.class, entity.getPkprofessor()));
	}

	public List<Professor> listarTodos() {
		return manager.createQuery("from Professor order by pkprofessor desc", Professor.class).getResultList();
	}

	public List<Professor> buscarPorDescricao(String campo, String value) {
		return manager.createQuery(
				"from Professor p join fetch p.disciplina where " + campo + " like :value order by p.professor",
				Professor.class).setParameter("value", "%" + value.toUpperCase() + "%").getResultList();
	}

	public List<Professor> buscarPorRelacionamento(String campo, Object value) {
		return manager.createQuery(
				"from Professor p join fetch p.disciplina where " + campo + " = :value order by p.professor",
				Professor.class).setParameter("value", value).getResultList();
	}

}
