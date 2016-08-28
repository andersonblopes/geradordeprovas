package geradordeprovas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import geradordeprovas.modelo.Sexo;

public class SexoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Sexo obterPorID(Integer pksexo) {
		return manager.find(Sexo.class, pksexo);
	}

	public Sexo guardar(Sexo entity) {
		return manager.merge(entity);
	}

	public void remover(Sexo entity) {
		manager.remove(manager.getReference(Sexo.class, entity.getPksexo()));
	}

	public List<Sexo> listarTodos() {
		return manager.createQuery("from Sexo order by sexo", Sexo.class).getResultList();
	}

	public List<Sexo> buscarPorDescricao(String campo, String value) {
		return manager.createQuery("from Sexo where " + campo + " like :value order by sexo", Sexo.class)
				.setParameter("value", "%" + value.toUpperCase() + "%").getResultList();
	}

	public List<Sexo> buscarPorRelacionamento(String campo, Object value) {
		return manager.createQuery("from Sexo where " + campo + " = :value order by sexo", Sexo.class)
				.setParameter("value", value).getResultList();
	}

}
