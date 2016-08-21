package geradordeprovas.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import geradordeprovas.modelo.Disciplina;
import geradordeprovas.repository.DisciplinaRepository;

@FacesConverter(forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {

	@Inject
	private DisciplinaRepository disciplinaRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			return disciplinaRepository.obterPorID(Integer.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Disciplina) {
			Disciplina disciplina = (Disciplina) value;
			return String.valueOf(disciplina.getPkdisciplina());
		}
		return "";
	}

}
