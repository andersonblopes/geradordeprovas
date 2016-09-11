package geradordeprovas.service.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.Disciplina;
import geradordeprovas.modelo.dao.GeralDAO;
import geradordeprovas.repository.DisciplinaRepository;
import geradordeprovas.util.Transacional;

public class DisciplinaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected DisciplinaRepository disciplinaRepository;

	@Inject
	protected GeralDAO<Disciplina> dao;

	@Transacional
	public void salvar(Disciplina disciplina) {
		dao.salvar(disciplina);
	}

	@Transacional
	public void remover(Disciplina disciplina) {
		dao.remover(disciplina);
	}

	@Transacional
	public List<Disciplina> listarTodos(String nomeDisciplina) {
		if (!nomeDisciplina.trim().equals("")) {
			return disciplinaRepository.buscarPorDescricao("disciplina", nomeDisciplina);
		}
		return disciplinaRepository.listarTodos();
	}

}
