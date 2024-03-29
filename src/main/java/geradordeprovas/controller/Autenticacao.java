package geradordeprovas.controller;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Named
@SessionScoped
public class Autenticacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private String usuario;
	private String senha;
	private String locale = "pt";
	private String encoding = "iso-8859-1";
	private String timeZone = "America/Fortaleza";

	public String autenticar() {

		if ((this.getUsuario().trim().equals("ALUNO") && this.getSenha().equals("aluno"))
				|| ((this.getUsuario().trim().equals("PROFESSOR") && this.getSenha().equals("professor"))
				|| ((this.getUsuario().trim().equals("ADMIN") && this.getSenha().equals("admin"))))) {
			return "/paginas/principal?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário/senha inválidos!!!", ""));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			return "";
		}
	}

	public String encerrarSessao() {
		((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession()
				.invalidate();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Logout efetuado com sucesso!", ""));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "/login?faces-redirect=true";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario.toUpperCase();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLocale() {
		return locale;
	}

	public String getEncoding() {
		return encoding;
	}

	public String getTimeZone() {
		return timeZone;
	}

}
