package geradordeprovas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import geradordeprovas.modelo.ItemQuestao;

public class ItemQuestaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public ItemQuestao obterPorID(Integer id) {
		return manager.find(ItemQuestao.class, id);
	}

	public List<ItemQuestao> listarTodos() {
		return manager.createQuery("from ItemQuestao order by itemQuestao", ItemQuestao.class).getResultList();
	}

	public List<ItemQuestao> buscarPorDescricao(String campo, String value) {
		return manager
				.createQuery("from ItemQuestao where " + campo + " like :value order by itemQuestao", ItemQuestao.class)
				.setParameter("value", "%" + value.toUpperCase() + "%").getResultList();
	}

	public List<ItemQuestao> buscarPorRelacionamento(String campo, Object value) {
		return manager
				.createQuery("from ItemQuestao where " + campo + " = :value order by itemQuestao", ItemQuestao.class)
				.setParameter("value", value).getResultList();
	}

}
