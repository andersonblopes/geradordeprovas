package geradordeprovas.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import geradordeprovas.modelo.PeriodoLetivo;
import geradordeprovas.repository.PeriodoLetivoRepository;

@FacesConverter(forClass = PeriodoLetivo.class)
public class PeriodoLetivoConverter implements Converter {

	@Inject
	protected PeriodoLetivoRepository anoLetivoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			return anoLetivoRepository.obterPorID(Integer.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof PeriodoLetivo) {
			PeriodoLetivo anoLetivo = (PeriodoLetivo) value;
			return String.valueOf(anoLetivo.getId());
		}
		return "";
	}

}
