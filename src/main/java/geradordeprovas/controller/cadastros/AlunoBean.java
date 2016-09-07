package geradordeprovas.controller.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import geradordeprovas.modelo.Aluno;
import geradordeprovas.service.cadastros.AlunoService;
import geradordeprovas.util.FacesUtils;

@Named
@ViewScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno aluno;

	private String nomePessoa;

	private List<Aluno> alunos;

	@Inject
	protected AlunoService alunoService;

	@Inject
	protected FacesUtils facesUtils;

	public void iniciar() {
		this.setNomePessoa("");
		pesquisar();
	}

	public void novo() {
		this.aluno = new Aluno();
	}

	public void salvar() {
		try {
			alunoService.salvar(getAluno());
			pesquisar();
			facesUtils.exibeSucesso("Registro cadastrado com sucesso!", null);
			this.aluno = null;
			iniciar();
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível inserir o registro!", e.getMessage());
		}
	}

	public void remover() {
		try {
			alunoService.remover(this.getAluno());
			this.pesquisar();
			facesUtils.exibeSucesso("registro removido com sucesso!", null);
			this.aluno = null;
			iniciar();
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível remover o registro!", null);
		}
	}

	public void limpar() {
		this.aluno = null;
	}

	public void pesquisar() {
		this.getAlunos();
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public List<Aluno> getAlunos() {
		this.alunos = alunoService.listarTodos(getNomePessoa());
		return alunos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
