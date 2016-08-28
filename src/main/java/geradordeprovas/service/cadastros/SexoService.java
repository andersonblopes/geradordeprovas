package geradordeprovas.service.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.Sexo;
import geradordeprovas.repository.SexoRepository;
import geradordeprovas.util.Transacional;

public class SexoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected SexoRepository sexoRepository;

	@Transacional
	public void salvar(Sexo sexo) {
		sexoRepository.guardar(sexo);
	}

	@Transacional
	public void remover(Sexo sexo) {
		sexoRepository.remover(sexo);
	}

	@Transacional
	public List<Sexo> listarTodos(String nomeSexo) {
		if (!nomeSexo.trim().equals("")) {
			return sexoRepository.buscarPorDescricao("sexo", nomeSexo);
		}
		return sexoRepository.listarTodos();
	}

}
