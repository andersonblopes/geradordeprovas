package geradordeprovas.service.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.TipoTurma;
import geradordeprovas.repository.TipoTurmaRepository;
import geradordeprovas.util.Transacional;

public class TipoTurmaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoTurmaRepository tipoTurmaRepository;

	@Transacional
	public void salvar(TipoTurma tipoTurma) {
		tipoTurmaRepository.guardar(tipoTurma);
	}

	@Transacional
	public void remover(TipoTurma tipoTurma) {
		tipoTurmaRepository.remover(tipoTurma);
	}

	@Transacional
	public List<TipoTurma> listarTodos(String nomeTipoTurma) {
		if (!nomeTipoTurma.trim().equals("")) {
			return tipoTurmaRepository.buscarPorDescricao("tipoturma", nomeTipoTurma);
		}
		return tipoTurmaRepository.listarTodos();
	}

}
