package geradordeprovas.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import geradordeprovas.modelo.ItemQuestao;
import geradordeprovas.repository.ItemQuestaoRepository;

@FacesConverter(forClass = ItemQuestao.class)
public class ItemQuestaoConverter implements Converter {

	@Inject
	private ItemQuestaoRepository itemQuestaoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			return itemQuestaoRepository.obterPorID(Integer.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof ItemQuestao) {
			ItemQuestao itemQuestao = (ItemQuestao) value;
			return String.valueOf(itemQuestao.getId());
		}
		return "";
	}

}
