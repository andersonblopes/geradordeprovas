package geradordeprovas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import geradordeprovas.modelo.Disciplina;
import geradordeprovas.service.DisciplinaRN;

@Named
@ViewScoped
public class ProfessorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Disciplina disciplina;

	private String nomeDisciplina;

	private List<Disciplina> disciplinas;

	@Inject
	protected DisciplinaRN disciplinaRN;

	public void iniciar() {
		this.setNomeDisciplina("");
		pesquisar();
	}

	public void novo() {
		this.disciplina = new Disciplina();
	}

	public void salvar() {
		try {
			disciplinaRN.salvar(this.disciplina);
			this.disciplina = new Disciplina();
			this.pesquisar();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro cadastrado com sucesso!", ""));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			this.disciplina = null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "não foi possível inserir o registro!", ""));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		}
	}

	public void remover() {
		try {
			disciplinaRN.remover(this.disciplina);
			this.pesquisar();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro removido com sucesso!", ""));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			this.disciplina = null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "não foi possível remover o registro!", ""));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		}
	}

	public void limpar() {
		this.disciplina = null;
	}

	public void pesquisar() {
		this.getDisciplinas();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public List<Disciplina> getDisciplinas() {
		this.disciplinas = disciplinaRN.listarTodos(getNomeDisciplina());
		return disciplinas;
	}

}
