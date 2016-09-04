package geradordeprovas.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import geradordeprovas.modelo.Professor;
import geradordeprovas.repository.ProfessorRepository;

@FacesConverter(forClass = Professor.class)
public class PtofessorConverter implements Converter {

	@Inject
	private ProfessorRepository professorRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			return professorRepository.obterPorID(Integer.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Professor) {
			Professor professor = (Professor) value;
			return String.valueOf(professor.getPkprofessor());
		}
		return "";
	}

}
