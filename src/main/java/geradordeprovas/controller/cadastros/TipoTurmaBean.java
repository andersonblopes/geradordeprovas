package geradordeprovas.controller.cadastros;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import geradordeprovas.modelo.TipoTurma;
import geradordeprovas.service.cadastros.TipoTurmaService;
import geradordeprovas.util.FacesUtils;

@Named
@ViewScoped
public class TipoTurmaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TipoTurma tipoTurma;

	private String nomeTipoTurma;

	private List<TipoTurma> tiposTurma;

	@Inject
	protected TipoTurmaService tipoTurmaRN;

	@Inject
	protected FacesUtils facesUtils;

	public void iniciar() {
		this.setNomeTipoTurma("");
		pesquisar();
	}

	public void novo() {
		this.tipoTurma = new TipoTurma();
	}

	public void salvar() {
		try {
			tipoTurmaRN.salvar(this.tipoTurma);
			this.tipoTurma = new TipoTurma();
			this.pesquisar();
			facesUtils.exibeSucesso("Registro cadastrado com sucesso!", null);
			this.tipoTurma = null;
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível inserir o registro!", null);
		}
	}

	public void remover() {
		try {
			tipoTurmaRN.remover(this.tipoTurma);
			this.pesquisar();
			facesUtils.exibeSucesso("Registro removido com sucesso!", null);
			this.tipoTurma = null;
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível remover o registro!", null);
		}
	}

	public void limpar() {
		this.tipoTurma = null;
	}

	public void openWindow() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("responsive", true);
		RequestContext.getCurrentInstance().openDialog("/paginas/cadastros/academico/tipo-turma", opcoes, null);
	}

	public void pesquisar() {
		this.getTiposTurma();
	}

	public TipoTurma getTipoTurma() {
		return tipoTurma;
	}

	public void setTipoTurma(TipoTurma tipoTurma) {
		this.tipoTurma = tipoTurma;
	}

	public String getNomeTipoTurma() {
		return nomeTipoTurma;
	}

	public void setNomeTipoTurma(String nomeTipoTurma) {
		this.nomeTipoTurma = nomeTipoTurma;
	}

	public List<TipoTurma> getTiposTurma() {
		this.tiposTurma = tipoTurmaRN.listarTodos(getNomeTipoTurma());
		return tiposTurma;
	}

}
