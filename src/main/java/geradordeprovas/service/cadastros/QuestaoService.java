package geradordeprovas.service.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import geradordeprovas.modelo.Conteudo;
import geradordeprovas.modelo.Disciplina;
import geradordeprovas.modelo.Questao;
import geradordeprovas.modelo.dao.GeralDAO;
import geradordeprovas.repository.ConteudoRepository;
import geradordeprovas.repository.DisciplinaRepository;
import geradordeprovas.repository.QuestaoRepository;
import geradordeprovas.util.Transacional;

public class QuestaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private QuestaoRepository questaoRepository;

	@Inject
	protected GeralDAO<Questao> dao;

	@Inject
	protected ConteudoRepository conteudoRepository;

	@Inject
	protected DisciplinaRepository disciplinaRepository;

	@Transacional
	public void salvar(Questao questao) {
		dao.salvar(questao);
	}

	@Transacional
	public void remover(Questao questao) {
		dao.remover(questao);
	}

	@Transacional
	public List<Questao> listarTodos(String questao) {
		if (!questao.trim().equals("")) {
			return questaoRepository.buscarPorDescricao("questao", questao);
		}
		return questaoRepository.listarTodos();
	}

	@Transacional
	public List<Conteudo> listarConteudos(String conteudo) {
		if (!conteudo.trim().equals("")) {
			return conteudoRepository.buscarPorDescricao("conteudo", conteudo);
		}
		return conteudoRepository.listarTodos();
	}

	@Transacional
	public List<Disciplina> listarDisciplinas(String disciplina) {
		if (!disciplina.trim().equals("")) {
			return disciplinaRepository.buscarPorDescricao("disciplina", disciplina);
		}
		return disciplinaRepository.listarTodos();
	}

}
