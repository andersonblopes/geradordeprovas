package geradordeprovas.controller.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import geradordeprovas.modelo.Conteudo;
import geradordeprovas.modelo.Disciplina;
import geradordeprovas.modelo.PeriodoLetivo;
import geradordeprovas.service.cadastros.ConteudoService;
import geradordeprovas.util.FacesUtils;

@Named
@ViewScoped
public class ConteudoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Conteudo conteudo;

	private String nomeConteudo;

	@Inject
	protected ConteudoService conteudoService;

	@Inject
	protected FacesUtils facesUtils;

	private List<Conteudo> conteudos;

	public void iniciar() {
		this.setNomeConteudo("");
		pesquisar();
	}

	public void novo() {
		this.conteudo = new Conteudo();
		this.conteudo.setDisciplina(new Disciplina());
		this.conteudo.setPeriodoLetivo(new PeriodoLetivo());
	}

	public void salvar() {
		try {
			conteudoService.salvar(this.conteudo);
			this.conteudo = new Conteudo();
			this.pesquisar();
			facesUtils.exibeSucesso("Registro cadastrado com sucesso!", null);
			this.conteudo = null;
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível inserir o registro!", null);
		}
	}

	public void remover() {
		try {
			conteudoService.remover(this.conteudo);
			this.pesquisar();
			facesUtils.exibeSucesso("Registro removido com sucesso!", null);
			this.conteudo = null;
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível remover o registro!", null);
		}
	}

	public void limpar() {
		this.conteudo = null;
	}

	public void pesquisar() {
		this.getConteudos();
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public String getNomeConteudo() {
		return nomeConteudo;
	}

	public void setNomeConteudo(String nomeConteudo) {
		this.nomeConteudo = nomeConteudo;
	}

	public List<Conteudo> getConteudos() {
		conteudos = conteudoService.listarTodos(getNomeConteudo());
		return conteudos;
	}

	public List<Disciplina> listarDisciplinas(String query) {
		return conteudoService.listarDisciplinas(query);
	}

	public List<PeriodoLetivo> listarPeriodosLetivos(String query) {
		return conteudoService.listarPeriodosLetivos(query);
	}

}
