package geradordeprovas.service.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.Aluno;
import geradordeprovas.modelo.Sexo;
import geradordeprovas.repository.AlunoRepository;
import geradordeprovas.repository.SexoRepository;
import geradordeprovas.util.Transacional;

public class AlunoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected AlunoRepository alunoRepository;

	@Inject
	protected SexoRepository sexoRepository;

	@Transacional
	public void salvar(Aluno aluno) {
		alunoRepository.guardar(aluno);
	}

	@Transacional
	public void remover(Aluno aluno) {
		alunoRepository.remover(aluno);
	}

	@Transacional
	public List<Aluno> listarTodos(String nomeAluno) {
		if (!nomeAluno.trim().equals("")) {
			return alunoRepository.buscarPorDescricao("nome", nomeAluno);
		}
		return alunoRepository.listarTodos();
	}

	public List<Sexo> listarSexos(String nomeSexo) {
		if (!nomeSexo.trim().equals("")) {
			return sexoRepository.buscarPorDescricao("sexo", nomeSexo);
		}
		return sexoRepository.listarTodos();
	}

}
