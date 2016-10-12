package geradordeprovas.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import geradordeprovas.modelo.Questao;
import geradordeprovas.repository.QuestaoRepository;

@FacesConverter(forClass = Questao.class)
public class QuestaoConverter implements Converter {

	@Inject
	private QuestaoRepository questaoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			return questaoRepository.obterPorID(Integer.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Questao) {
			Questao questao = (Questao) value;
			return String.valueOf(questao.getId());
		}
		return "";
	}

}
