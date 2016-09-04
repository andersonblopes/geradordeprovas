package geradordeprovas.service.cadastro.test;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import geradordeprovas.controller.Autenticacao;

public class AutenticacaoTest {

	@Test
	public void deveRetornarURLAluno() {
		Autenticacao autenticacao = new Autenticacao();
		autenticacao.setUsuario("ALUNO");
		autenticacao.setSenha("aluno");
		Assert.assertEquals("resultado", "/paginas/principal?faces-redirect=true", autenticacao.autenticar());
	}

	@Test
	public void deveRetornarURLAdmin() {
		Autenticacao autenticacao = new Autenticacao();
		autenticacao.setUsuario("ADMIN");
		autenticacao.setSenha("admin");
		Assert.assertEquals("resultado", "/paginas/principal?faces-redirect=true", autenticacao.autenticar());
	}

	@Test
	public void deveRetornarURLProfessor() {
		Autenticacao autenticacao = new Autenticacao();
		autenticacao.setUsuario("PROFESSOR");
		autenticacao.setSenha("professor");
		Assert.assertEquals("resultado", "/paginas/principal?faces-redirect=true", autenticacao.autenticar());
	}

	@Test
	public void obterLocalePortuguesBrasil() {
		Autenticacao autenticacao = new Autenticacao();
		System.out.println(Locale.getDefault());
		Assert.assertEquals("Idioma porrtugues", autenticacao.getLocale(), Locale.getDefault().toString());
	}

}
