package geradordeprovas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import geradordeprovas.modelo.Conteudo;

public class ConteudoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Conteudo obterPorID(Integer pk) {
		return manager.find(Conteudo.class, pk);
	}

	public List<Conteudo> listarTodos() {
		return manager.createQuery("from Conteudo order by conteudo desc", Conteudo.class).getResultList();
	}

	public List<Conteudo> buscarPorDescricao(String campo, String value) {
		return manager
				.createQuery("from Conteudo where " + campo + " like :value order by conteudo desc", Conteudo.class)
				.setParameter("value", "%" + value.toUpperCase() + "%").getResultList();
	}

	public List<Conteudo> buscarPorRelacionamento(String campo, Object value) {
		return manager.createQuery("from Conteudo where " + campo + " = :value order by conteudo desc", Conteudo.class)
				.setParameter("value", value).getResultList();
	}
}
