package geradordeprovas.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import geradordeprovas.modelo.Aluno;
import geradordeprovas.repository.AlunoRepository;

@FacesConverter(forClass = Aluno.class)
public class AlunoConverter implements Converter {

	@Inject
	private AlunoRepository alunoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			return alunoRepository.obterPorID(Integer.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Aluno) {
			Aluno aluno = (Aluno) value;
			return String.valueOf(aluno.getId());
		}
		return "";
	}

}
