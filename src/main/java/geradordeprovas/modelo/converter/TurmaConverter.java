package geradordeprovas.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import geradordeprovas.modelo.Turma;
import geradordeprovas.repository.TurmaRepository;

@FacesConverter(forClass = Turma.class)
public class TurmaConverter implements Converter {

	@Inject
	private TurmaRepository turmaRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			return turmaRepository.obterPorID(Integer.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Turma) {
			Turma turma = (Turma) value;
			return String.valueOf(turma.getPkturma());
		}
		return "";
	}

}

