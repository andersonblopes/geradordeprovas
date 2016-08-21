package geradordeprovas.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.Disciplina;
import geradordeprovas.repository.DisciplinaRepository;
import geradordeprovas.util.Transacional;

public class ProfessorRN implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	protected DisciplinaRepository disciplinaRepository;

	@Transacional
	public void salvar(Disciplina disciplina) {
		disciplinaRepository.guardar(disciplina);
	}

	@Transacional
	public void remover(Disciplina disciplina) {
		disciplinaRepository.remover(disciplina);
	}

	@Transacional
	public List<Disciplina> listarTodos(String nomeDisciplina) {
		if (!nomeDisciplina.trim().equals("")) {
			return disciplinaRepository.buscarPorDescricao("disciplina", nomeDisciplina);
		}
		return disciplinaRepository.listarTodos();
	}

}
