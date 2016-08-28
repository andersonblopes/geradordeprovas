package geradordeprovas.controller.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import geradordeprovas.modelo.Sexo;
import geradordeprovas.service.cadastros.SexoService;
import geradordeprovas.util.FacesUtils;

@Named
@ViewScoped
public class SexoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Sexo sexo;

	private String nomesexo;

	private List<Sexo> sexos;

	@Inject
	protected SexoService sexoService;

	@Inject
	protected FacesUtils facesUtils;

	public void iniciar() {
		this.setNomesexo("");
		pesquisar();
	}

	public void novo() {
		this.sexo = new Sexo();
	}

	public void salvar() {
		try {
			sexoService.salvar(this.sexo);
			this.sexo = new Sexo();
			this.pesquisar();
			facesUtils.exibeSucesso("Registro cadastrado com sucesso!", null);
			this.sexo = null;
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível inserir o registro!", null);
		}
	}

	public void remover() {
		try {
			sexoService.remover(this.sexo);
			this.pesquisar();
			facesUtils.exibeSucesso("Registro removido com sucesso!", null);
			this.sexo = null;
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível remover o registro!", null);
		}
	}

	public void limpar() {
		this.sexo = null;
	}

	public void pesquisar() {
		this.getSexos();
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNomesexo() {
		return nomesexo;
	}

	public void setNomesexo(String nomesexo) {
		this.nomesexo = nomesexo;
	}

	public List<Sexo> getSexos() {
		this.sexos = sexoService.listarTodos(getNomesexo());
		return sexos;
	}

}
