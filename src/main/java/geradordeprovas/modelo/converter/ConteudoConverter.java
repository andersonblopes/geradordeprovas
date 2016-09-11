package geradordeprovas.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import geradordeprovas.modelo.Conteudo;
import geradordeprovas.repository.ConteudoRepository;

@FacesConverter(forClass = Conteudo.class)
public class ConteudoConverter implements Converter {

	@Inject
	protected ConteudoRepository conteudoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			return conteudoRepository.obterPorID(Integer.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Conteudo) {
			Conteudo conteudo = (Conteudo) value;
			return String.valueOf(conteudo.getId());
		}
		return "";
	}
}
