package geradordeprovas.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer pkdisciplina;

	@NotEmpty
	@Column(columnDefinition = "text")
	private String disciplina;

	@NotEmpty
	@Column(columnDefinition = "text")
	private String codMec;

	private Integer cargaHoraria;

	public Integer getPkdisciplina() {
		return pkdisciplina;
	}

	public void setPkdisciplina(Integer pkdisciplina) {
		this.pkdisciplina = pkdisciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getCodMec() {
		return codMec;
	}

	public void setCodMec(String codMec) {
		this.codMec = codMec;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pkdisciplina == null) ? 0 : pkdisciplina.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (pkdisciplina == null) {
			if (other.pkdisciplina != null)
				return false;
		} else if (!pkdisciplina.equals(other.pkdisciplina))
			return false;
		return true;
	}

}
