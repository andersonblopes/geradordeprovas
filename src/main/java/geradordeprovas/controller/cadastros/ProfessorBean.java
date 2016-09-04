package geradordeprovas.controller.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import geradordeprovas.modelo.Disciplina;
import geradordeprovas.modelo.Professor;
import geradordeprovas.service.cadastros.ProfessorService;

@Named
@ViewScoped
public class ProfessorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Professor professor;

	private String nomeProfessor;

	private List<Professor> professores;

	@Inject
	protected ProfessorService professorService;

	public void iniciar() {
		this.setNomeProfessor("");
		pesquisar();
	}

	public void novo() {
		this.professor = new Professor();
	}

	public void salvar() {
		try {
			professorService.salvar(this.professor);
			this.professor = new Professor();
			this.pesquisar();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro cadastrado com sucesso!", ""));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			this.professor = null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "não foi possível inserir o registro!", ""));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		}
	}

	public void remover() {
		try {
			professorService.remover(this.professor);
			this.pesquisar();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro removido com sucesso!", ""));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			this.professor = null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "não foi possível remover o registro!", ""));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		}
	}

	public void limpar() {
		this.professor = null;
	}

	public void pesquisar() {
		this.getProfessores();
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public List<Professor> getProfessores() {
		this.professores = professorService.listarTodos(getNomeProfessor());
		return professores;
	}

	public List<Disciplina> listarDisciplinas(String query) {
		return professorService.listarDisciplinas(query);
	}

}
