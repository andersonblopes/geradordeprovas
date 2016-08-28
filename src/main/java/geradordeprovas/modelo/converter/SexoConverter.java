package geradordeprovas.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import geradordeprovas.modelo.Sexo;
import geradordeprovas.repository.SexoRepository;

@FacesConverter(forClass = Sexo.class)
public class SexoConverter implements Converter {

	@Inject
	private SexoRepository sexoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			return sexoRepository.obterPorID(Integer.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Sexo) {
			Sexo sexo = (Sexo) value;
			return String.valueOf(sexo.getPksexo());
		}
		return "";
	}

}

