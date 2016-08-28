package geradordeprovas.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "sexo")
@NamedQuery(name = "Sexo.findAll", query = "SELECT s FROM Sexo s")
public class Sexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer pksexo;

	@Column(nullable = false, columnDefinition = "text")
	private String codsexo;

	@Column(nullable = false, columnDefinition = "text")
	private String sexo;

	public Sexo() {
	}

	public Integer getPksexo() {
		return this.pksexo;
	}

	public void setPksexo(Integer pksexo) {
		this.pksexo = pksexo;
	}

	public String getCodsexo() {
		return this.codsexo;
	}

	public void setCodsexo(String codsexo) {
		this.codsexo = codsexo;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pksexo == null) ? 0 : pksexo.hashCode());
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
		Sexo other = (Sexo) obj;
		if (pksexo == null) {
			if (other.pksexo != null)
				return false;
		} else if (!pksexo.equals(other.pksexo))
			return false;
		return true;
	}

}
