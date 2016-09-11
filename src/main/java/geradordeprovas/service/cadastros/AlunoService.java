package geradordeprovas.service.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.Aluno;
import geradordeprovas.modelo.dao.GeralDAO;
import geradordeprovas.repository.AlunoRepository;
import geradordeprovas.util.Transacional;

public class AlunoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected AlunoRepository alunoRepository;

	@Inject
	protected GeralDAO<Aluno> dao;

	@Transacional
	public void salvar(Aluno aluno) {
		dao.salvar(aluno);
	}

	@Transacional
	public void remover(Aluno aluno) {
		dao.remover(aluno);
	}

	public List<Aluno> listarTodos(String nomeAluno) {
		if (!nomeAluno.trim().equals("")) {
			return alunoRepository.buscarPorDescricao("nome", nomeAluno);
		}
		return alunoRepository.listarTodos();
	}

}
