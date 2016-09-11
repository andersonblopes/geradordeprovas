package geradordeprovas.controller.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import geradordeprovas.modelo.PeriodoLetivo;
import geradordeprovas.service.cadastros.PeriodoLetivoService;
import geradordeprovas.util.FacesUtils;

@Named
@ViewScoped
public class PeriodoLetivoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PeriodoLetivo periodoLetivo;

	private String nomePeriodoLetivo;

	private List<PeriodoLetivo> periodosLetivos;

	@Inject
	protected PeriodoLetivoService periodoLetivoService;

	@Inject
	protected FacesUtils facesUtils;

	public void iniciar() {
		this.setNomePeriodoLetivo("");
		pesquisar();
	}

	public void novo() {
		this.periodoLetivo = new PeriodoLetivo();
	}

	public void salvar() {
		try {
			periodoLetivoService.salvar(this.periodoLetivo);
			this.periodoLetivo = new PeriodoLetivo();
			this.pesquisar();
			facesUtils.exibeSucesso("Registro cadastrado com sucesso!", null);
			this.periodoLetivo = null;
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível inserir o registro!", null);
		}
	}

	public void remover() {
		try {
			periodoLetivoService.remover(this.periodoLetivo);
			this.pesquisar();
			facesUtils.exibeSucesso("Registro removido com sucesso!", null);
			this.periodoLetivo = null;
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível remover o registro!", null);
		}
	}

	public void limpar() {
		this.periodoLetivo = null;
	}

	public void pesquisar() {
		this.getPeriodosLetivos();
	}

	public PeriodoLetivo getPeriodoLetivo() {
		return periodoLetivo;
	}

	public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public String getNomePeriodoLetivo() {
		return nomePeriodoLetivo;
	}

	public void setNomePeriodoLetivo(String nomePeriodoLetivo) {
		this.nomePeriodoLetivo = nomePeriodoLetivo;
	}

	public List<PeriodoLetivo> getPeriodosLetivos() {
		this.periodosLetivos = periodoLetivoService.listarTodos(getNomePeriodoLetivo());
		return periodosLetivos;
	}

}
