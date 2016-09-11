package geradordeprovas.service.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.Conteudo;
import geradordeprovas.modelo.Disciplina;
import geradordeprovas.modelo.PeriodoLetivo;
import geradordeprovas.modelo.dao.GeralDAO;
import geradordeprovas.repository.ConteudoRepository;
import geradordeprovas.repository.DisciplinaRepository;
import geradordeprovas.repository.PeriodoLetivoRepository;
import geradordeprovas.util.Transacional;

public class ConteudoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected ConteudoRepository conteudoRepository;

	@Inject
	protected DisciplinaRepository disciplinaRepository;

	@Inject
	protected PeriodoLetivoRepository periodoLetivoRepository;

	@Inject
	protected GeralDAO<Conteudo> dao;

	@Transacional
	public void salvar(Conteudo conteudo) {
		dao.salvar(conteudo);
	}

	@Transacional
	public void remover(Conteudo conteudo) {
		dao.remover(conteudo);
	}

	public List<Conteudo> listarTodos(String conteudo) {
		if (!conteudo.trim().equals("")) {
			return conteudoRepository.buscarPorDescricao("conteudo", conteudo);
		}
		return conteudoRepository.listarTodos();
	}

	public List<Disciplina> listarDisciplinas(String disciplina) {
		if (!disciplina.trim().equals("")) {
			return disciplinaRepository.buscarPorDescricao("disciplina", disciplina);
		}
		return disciplinaRepository.listarTodos();
	}

	public List<PeriodoLetivo> listarPeriodosLetivos(String periodoLetivo) {
		if (!periodoLetivo.trim().equals("")) {
			return periodoLetivoRepository.buscarPorDescricao("periodoLetivo", periodoLetivo);
		}
		return periodoLetivoRepository.listarTodos();
	}

}
