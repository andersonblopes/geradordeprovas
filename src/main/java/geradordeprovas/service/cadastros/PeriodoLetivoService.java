package geradordeprovas.service.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.PeriodoLetivo;
import geradordeprovas.modelo.dao.GeralDAO;
import geradordeprovas.repository.PeriodoLetivoRepository;
import geradordeprovas.util.Transacional;

public class PeriodoLetivoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected PeriodoLetivoRepository periodoLetivoRepository;

	@Inject
	protected GeralDAO<PeriodoLetivo> dao;

	@Transacional
	public void salvar(PeriodoLetivo periodoLetivo) {
		dao.salvar(periodoLetivo);
	}

	@Transacional
	public void remover(PeriodoLetivo periodoLetivo) {
		dao.remover(periodoLetivo);
	}

	@Transacional
	public List<PeriodoLetivo> listarTodos(String nomePeriodoLetivo) {
		if (!nomePeriodoLetivo.trim().equals("")) {
			return periodoLetivoRepository.buscarPorDescricao("periodoLetivo", nomePeriodoLetivo);
		}
		return periodoLetivoRepository.listarTodos();
	}

}
