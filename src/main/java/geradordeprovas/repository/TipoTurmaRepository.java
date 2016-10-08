package geradordeprovas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import geradordeprovas.modelo.TipoTurma;

public class TipoTurmaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public TipoTurma obterPorID(Integer pktipoturma) {
		return manager.find(TipoTurma.class, pktipoturma);
	}

	public List<TipoTurma> listarTodos() {
		return manager.createQuery("from TipoTurma order by tipoturma", TipoTurma.class).getResultList();
	}

	public List<TipoTurma> buscarPorDescricao(String campo, String value) {
		return manager.createQuery("from TipoTurma where " + campo + " like :value order by tipoturma", TipoTurma.class)
				.setParameter("value", "%" + value.toUpperCase() + "%").getResultList();
	}

	public List<TipoTurma> buscarPorRelacionamento(String campo, Object value) {
		return manager.createQuery("from TipoTurma where " + campo + " = :value order by tipoturma", TipoTurma.class)
				.setParameter("value", value).getResultList();
	}

}
