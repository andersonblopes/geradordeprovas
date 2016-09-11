package geradordeprovas.util;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class FacesUtils {

	public void exibeErro(String cabecalho, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, cabecalho, mensagem));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}

	public void exibeSucesso(String cabecalho, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, cabecalho, mensagem));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}

	public void atribuirVariavelSessao(String sVariavel, Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(sVariavel, value);
	}

	public Object obterVariavelSessao(String sVariavel) {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(sVariavel);
	}

	public void invalidarSessao() {
		((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession()
				.invalidate();
		;
	}

}
