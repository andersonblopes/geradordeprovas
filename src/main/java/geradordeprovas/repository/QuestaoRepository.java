package geradordeprovas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import geradordeprovas.modelo.Questao;

public class QuestaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Questao obterPorID(Integer id) {
		return manager.find(Questao.class, id);
	}

	public List<Questao> listarTodos() {
		return manager.createQuery("from Questao order by questao", Questao.class).getResultList();
	}

	public List<Questao> buscarPorDescricao(String campo, String value) {
		return manager.createQuery("from Questao where " + campo + " like :value order by questao", Questao.class)
				.setParameter("value", "%" + value.toUpperCase() + "%").getResultList();
	}

	public List<Questao> buscarPorRelacionamento(String campo, Object value) {
		return manager.createQuery("from Questao where " + campo + " = :value order by questao", Questao.class)
				.setParameter("value", value).getResultList();
	}

}
