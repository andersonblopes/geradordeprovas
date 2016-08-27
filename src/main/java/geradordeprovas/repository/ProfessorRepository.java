package geradordeprovas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import geradordeprovas.modelo.Disciplina;

public class ProfessorRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Disciplina obterPorID(Integer pk) {
		return manager.find(Disciplina.class, pk);
	}

	public Disciplina guardar(Disciplina entity) {
		return manager.merge(entity);
	}

	public void remover(Disciplina entity) {
		manager.remove(manager.getReference(Disciplina.class, entity.getPkdisciplina()));
	}

	public List<Disciplina> listarTodos() {
		return manager.createQuery("from Disciplina order by pkdisciplina desc", Disciplina.class).getResultList();
	}

	public List<Disciplina> buscarPorDescricao(String campo, String value) {
		return manager
				.createQuery("from Disciplina where " + campo + " like :value order by disciplina", Disciplina.class)
				.setParameter("value", "%" + value.toUpperCase() + "%").getResultList();
	}

	public List<Disciplina> buscarPorRelacionamento(String campo, Object value) {
		return manager.createQuery("from Disciplina where " + campo + " = :value order by disciplina", Disciplina.class)
				.setParameter("value", value).getResultList();
	}

}