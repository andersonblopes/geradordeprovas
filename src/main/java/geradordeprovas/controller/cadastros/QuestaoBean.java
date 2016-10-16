package geradordeprovas.controller.cadastros;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import geradordeprovas.modelo.Conteudo;
import geradordeprovas.modelo.ItemQuestao;
import geradordeprovas.modelo.Questao;
import geradordeprovas.service.cadastros.ConteudoService;
import geradordeprovas.service.cadastros.ItemQuestaoService;
import geradordeprovas.service.cadastros.QuestaoService;
import geradordeprovas.util.FacesUtils;

@Named
@ViewScoped
public class QuestaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Questao questao;
	private ItemQuestao itemQuestao;
	private String descricaoQuestao;
	private List<Questao> questoes;
	private List<ItemQuestao> itensQuestao;

	@Inject
	protected QuestaoService questaoService;

	@Inject
	protected ItemQuestaoService itemQuestaoService;

	@Inject
	protected ConteudoService conteudoService;

	@Inject
	protected FacesUtils facesUtils;

	public void iniciar() {
		this.setDescricaoQuestao("");
		pesquisar();
	}

	public void novo() {
		this.questao = new Questao();
	}

	public void salvar() {
		try {
			questaoService.salvar(this.questao);
			novo();
			this.pesquisar();
			facesUtils.exibeSucesso("Registro cadastrado com sucesso!", null);
			limpar();
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível inserir o registro!", null);
		}
	}

	public void remover() {
		try {
			questaoService.remover(this.questao);
			this.pesquisar();
			facesUtils.exibeSucesso("Registro cadastrado com sucesso!", null);
			limpar();
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível remover o registro!", null);
		}
	}

	public void limpar() {
		this.questao = null;
	}

	public void pesquisar() {
		this.getQuestao();
	}

	public void novoItemQuestao() {
		setItemQuestao(new ItemQuestao(this.getQuestao()));
	}

	public void salvarItemQuestao() {
		try {
			itemQuestaoService.salvar(getItemQuestao());
			novoItemQuestao();
			facesUtils.exibeSucesso("Registro cadastrado com sucesso!", null);
			this.pesquisarItens();
			limparItemQuestao();
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível inserir o registro!", null);
		}
	}

	public void removerItemQuestao() {
		try {
			getItemQuestao().setQuestao(null);
			itemQuestaoService.remover(getItemQuestao());
			this.pesquisarItens();
			facesUtils.exibeSucesso("Registro removido com sucesso!", null);
			limparItemQuestao();
		} catch (Exception e) {
			facesUtils.exibeErro("não foi possível remover o registro!", null);
		}
	}

	public void limparItemQuestao() {
		this.itemQuestao = null;
	}

	public void pesquisarItens() {
		this.getItensQuestao();
	}

	public List<ItemQuestao> getItensQuestao() {
		itensQuestao = itemQuestaoService.listarTodos(getQuestao());
		return itensQuestao;
	}

	public ItemQuestao getItemQuestao() {
		return itemQuestao;
	}

	public void setItemQuestao(ItemQuestao itemQuestao) {
		this.itemQuestao = itemQuestao;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public String getDescricaoQuestao() {
		return descricaoQuestao;
	}

	public void setDescricaoQuestao(String descricaoQuestao) {
		this.descricaoQuestao = descricaoQuestao;
	}

	public List<Questao> getQuestoes() {
		questoes = questaoService.listarTodos(getDescricaoQuestao());
		return questoes;
	}

	public List<Conteudo> listarConteudos(String query) {
		return conteudoService.listarTodos(query);
	}

}
