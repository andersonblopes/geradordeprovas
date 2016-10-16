package geradordeprovas.service.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.ItemQuestao;
import geradordeprovas.modelo.Questao;
import geradordeprovas.modelo.dao.GeralDAO;
import geradordeprovas.repository.ItemQuestaoRepository;
import geradordeprovas.util.Transacional;

public class ItemQuestaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected ItemQuestaoRepository itemQuestaoRepository;

	@Inject
	protected GeralDAO<ItemQuestao> dao;

	@Transacional
	public void salvar(ItemQuestao itemQuestao) {
		dao.salvar(itemQuestao);
	}

	@Transacional
	public void remover(ItemQuestao itemQuestao) {
		dao.remover(itemQuestao);
	}

	@Transacional
	public List<ItemQuestao> listarTodos(String itemQuestao) {
		if (!itemQuestao.trim().equals("")) {
			return itemQuestaoRepository.buscarPorDescricao("itemQuestao", itemQuestao);
		}
		return itemQuestaoRepository.listarTodos();
	}

	@Transacional
	public List<ItemQuestao> listarTodos(Questao questao) {
		return itemQuestaoRepository.buscarPorRelacionamento("questao", questao);
	}

}
