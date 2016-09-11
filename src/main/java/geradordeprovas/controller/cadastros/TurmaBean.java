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
import geradordeprovas.modelo.Turma;
import geradordeprovas.service.cadastros.TurmaService;
import geradordeprovas.util.FacesUtils;

@Named
@ViewScoped
public class TurmaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Turma turma;

	private String nomeTurma;

	private List<Turma> turmas;

	@Inject
	protected TurmaService turmaRN;

	@Inject
	protected FacesUtils facesUtils;

	public void iniciar() {
		this.setNomeTurma("");
		pesquisar();
	}

	public void novo() {
		this.turma = new Turma();
	}

	public void salvar() {
		try {
			turmaRN.salvar(this.turma);
			this.turma = new Turma();
			this.pesquisar();
			facesUtils.exibeSucesso("Registro cadastrado com sucesso!", null);
			this.turma = null;
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível inserir o registro!", null);
		}
	}

	public void remover() {
		try {
			turmaRN.remover(this.turma);
			this.pesquisar();
			facesUtils.exibeSucesso("Registro removido com sucesso!", null);
			this.turma = null;
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível remover o registro!", null);
		}
	}

	public void limpar() {
		this.turma = null;
	}

	public void openWindow() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("responsive", true);
		RequestContext.getCurrentInstance().openDialog("/paginas/cadastros/academico/turma", opcoes, null);
	}

	public void pesquisar() {
		this.getTurmas();
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public List<Turma> getTurmas() {
		this.turmas = turmaRN.listarTodos(getNomeTurma());
		return turmas;
	}

	public List<TipoTurma> listarTiposTurma(String query) {
		return turmaRN.listarTiposTurma(query);
	}

}
