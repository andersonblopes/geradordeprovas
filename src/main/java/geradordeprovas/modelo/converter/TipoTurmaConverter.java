package geradordeprovas.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import geradordeprovas.modelo.TipoTurma;
import geradordeprovas.repository.TipoTurmaRepository;

@FacesConverter(forClass = TipoTurma.class)
public class TipoTurmaConverter implements Converter {

	@Inject
	private TipoTurmaRepository tipoTurmaRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			return tipoTurmaRepository.obterPorID(Integer.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof TipoTurma) {
			TipoTurma tipoTurma = (TipoTurma) value;
			return String.valueOf(tipoTurma.getPktipoturma());
		}
		return "";
	}

}

