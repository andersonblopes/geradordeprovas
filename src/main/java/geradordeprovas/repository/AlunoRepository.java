package geradordeprovas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import geradordeprovas.modelo.Aluno;

public class AlunoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Aluno obterPorID(Integer id) {
		return manager.find(Aluno.class, id);
	}

	public Aluno guardar(Aluno entity) {
		return manager.merge(entity);
	}

	public void remover(Aluno entity) {
		manager.remove(manager.getReference(Aluno.class, entity.getId()));
	}

	public List<Aluno> listarTodos() {
		return manager.createQuery("from Aluno order by id desc", Aluno.class).getResultList();
	}

	public List<Aluno> buscarPorDescricao(String campo, String value) {
		return manager.createQuery("from Aluno where " + campo + " like :value order by nome", Aluno.class)
				.setParameter("value", "%" + value.toUpperCase() + "%").getResultList();
	}

	public List<Aluno> buscarPorRelacionamento(String campo, Object value) {
		return manager.createQuery("from Aluno where " + campo + " = :value order by nome", Aluno.class)
				.setParameter("value", value).getResultList();
	}

}
