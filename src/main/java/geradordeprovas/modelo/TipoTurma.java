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
@Table(name = "tipoturma")
public class TipoTurma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer pktipoturma;

	@NotEmpty
	@Column(columnDefinition = "text", unique = true)
	private String tipoturma;

	@NotEmpty
	@Column(columnDefinition = "text", unique = true)
	private String codtipoturma;

	public Integer getPktipoturma() {
		return pktipoturma;
	}

	public void setPktipoturma(Integer pktipoturma) {
		this.pktipoturma = pktipoturma;
	}

	public String getTipoturma() {
		return tipoturma;
	}

	public void setTipoturma(String tipoturma) {
		this.tipoturma = tipoturma;
	}

	public String getCodtipoturma() {
		return codtipoturma;
	}

	public void setCodtipoturma(String codtipoturma) {
		this.codtipoturma = codtipoturma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pktipoturma == null) ? 0 : pktipoturma.hashCode());
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
		TipoTurma other = (TipoTurma) obj;
		if (pktipoturma == null) {
			if (other.pktipoturma != null)
				return false;
		} else if (!pktipoturma.equals(other.pktipoturma))
			return false;
		return true;
	}

}
