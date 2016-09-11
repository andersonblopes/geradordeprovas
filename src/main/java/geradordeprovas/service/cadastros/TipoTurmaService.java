package geradordeprovas.service.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.TipoTurma;
import geradordeprovas.modelo.dao.GeralDAO;
import geradordeprovas.repository.TipoTurmaRepository;
import geradordeprovas.util.Transacional;

public class TipoTurmaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoTurmaRepository tipoTurmaRepository;

	@Inject
	protected GeralDAO<TipoTurma> dao;

	@Transacional
	public void salvar(TipoTurma tipoTurma) {
		dao.salvar(tipoTurma);
	}

	@Transacional
	public void remover(TipoTurma tipoTurma) {
		dao.remover(tipoTurma);
	}

	@Transacional
	public List<TipoTurma> listarTodos(String nomeTipoTurma) {
		if (!nomeTipoTurma.trim().equals("")) {
			return tipoTurmaRepository.buscarPorDescricao("tipoturma", nomeTipoTurma);
		}
		return tipoTurmaRepository.listarTodos();
	}

}
