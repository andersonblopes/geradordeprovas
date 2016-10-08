package geradordeprovas.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer pkturma;

	@NotEmpty
	@Column(columnDefinition = "text")
	private String turma;

	@Column(columnDefinition = "text")
	private String codmec;

	@NotEmpty
	@Column(columnDefinition = "text")
	private String horaInicial;

	@NotEmpty
	@Column(columnDefinition = "text")
	private String horaFinal;

	private boolean maisEducacao;

	@ManyToOne
	@JoinColumn(name = "fktipoturma")
	private TipoTurma tipoTurma;

	public Integer getPkturma() {
		return pkturma;
	}

	public void setPkturma(Integer pkturma) {
		this.pkturma = pkturma;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getCodmec() {
		return codmec;
	}

	public void setCodmec(String codmec) {
		this.codmec = codmec;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public boolean isMaisEducacao() {
		return maisEducacao;
	}

	public void setMaisEducacao(boolean maisEducacao) {
		this.maisEducacao = maisEducacao;
	}

	public TipoTurma getTipoTurma() {
		return tipoTurma;
	}

	public void setTipoTurma(TipoTurma tipoTurma) {
		this.tipoTurma = tipoTurma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pkturma == null) ? 0 : pkturma.hashCode());
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
		Turma other = (Turma) obj;
		if (pkturma == null) {
			if (other.pkturma != null)
				return false;
		} else if (!pkturma.equals(other.pkturma))
			return false;
		return true;
	}

}
