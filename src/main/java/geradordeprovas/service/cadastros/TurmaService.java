package geradordeprovas.service.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.TipoTurma;
import geradordeprovas.modelo.Turma;
import geradordeprovas.modelo.dao.GeralDAO;
import geradordeprovas.repository.TipoTurmaRepository;
import geradordeprovas.repository.TurmaRepository;
import geradordeprovas.util.Transacional;

public class TurmaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TurmaRepository turmaRepository;

	@Inject
	private TipoTurmaRepository tipoTurmaRepository;

	@Inject
	protected GeralDAO<Turma> dao;

	@Transacional
	public void salvar(Turma turma) {
		dao.salvar(turma);
	}

	@Transacional
	public void remover(Turma turma) {
		dao.remover(turma);
	}

	@Transacional
	public List<Turma> listarTodos(String nomeTurma) {
		if (!nomeTurma.trim().equals("")) {
			return turmaRepository.buscarPorDescricao("turma", nomeTurma);
		}
		return turmaRepository.listarTodos();
	}

	@Transacional
	public List<TipoTurma> listarTiposTurma(String nomeTipoTurma) {
		if (!nomeTipoTurma.trim().equals("")) {
			return tipoTurmaRepository.buscarPorDescricao("tipoturma", nomeTipoTurma);
		}
		return tipoTurmaRepository.listarTodos();
	}

}
