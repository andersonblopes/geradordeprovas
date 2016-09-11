package geradordeprovas.service.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.Disciplina;
import geradordeprovas.modelo.Professor;
import geradordeprovas.modelo.dao.GeralDAO;
import geradordeprovas.repository.DisciplinaRepository;
import geradordeprovas.repository.ProfessorRepository;
import geradordeprovas.util.Transacional;

public class ProfessorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected ProfessorRepository professorRepository;

	@Inject
	protected DisciplinaRepository disciplinaRepository;

	@Inject
	protected GeralDAO<Professor> dao;

	@Transacional
	public void salvar(Professor professor) {
		dao.salvar(professor);
	}

	@Transacional
	public void remover(Professor Professor) {
		dao.remover(Professor);
	}

	@Transacional
	public List<Professor> listarTodos(String nomeProfessor) {
		if (!nomeProfessor.trim().equals("")) {
			return professorRepository.buscarPorDescricao("professor", nomeProfessor);
		}
		return professorRepository.listarTodos();
	}

	@Transacional
	public List<Disciplina> listarDisciplinas(String query) {
		if (query.trim().equals("")) {
			return disciplinaRepository.buscarPorDescricao("disciplina", query);
		}
		return disciplinaRepository.listarTodos();
	}

}
