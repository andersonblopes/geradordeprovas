package geradordeprovas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import geradordeprovas.modelo.PeriodoLetivo;

public class PeriodoLetivoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public PeriodoLetivo obterPorID(Integer pk) {
		return manager.find(PeriodoLetivo.class, pk);
	}

	public List<PeriodoLetivo> listarTodos() {
		return manager.createQuery("from PeriodoLetivo order by periodoLetivo desc", PeriodoLetivo.class)
				.getResultList();
	}

	public List<PeriodoLetivo> buscarPorDescricao(String campo, String value) {
		return manager.createQuery("from PeriodoLetivo where " + campo + " like :value order by periodoLetivo desc",
				PeriodoLetivo.class).setParameter("value", "%" + value.toUpperCase() + "%").getResultList();
	}

	public List<PeriodoLetivo> buscarPorRelacionamento(String campo, Object value) {
		return manager.createQuery("from PeriodoLetivo where " + campo + " = :value order by periodoLetivo desc",
				PeriodoLetivo.class).setParameter("value", value).getResultList();
	}

}
