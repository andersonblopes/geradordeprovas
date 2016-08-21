package geradordeprovas.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "professor")
@NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p")
public class Professor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer pkprofessor;

	@NotEmpty
	@Column(columnDefinition = "text")
	private String professor;

	@ManyToOne
	@JoinColumn(name = "fkdisciplina", referencedColumnName = "pkdisciplina")
	private Disciplina disciplina;

	public Integer getPkprofessor() {
		return pkprofessor;
	}

	public void setPkprofessor(Integer pkprofessor) {
		this.pkprofessor = pkprofessor;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pkprofessor == null) ? 0 : pkprofessor.hashCode());
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
		Professor other = (Professor) obj;
		if (pkprofessor == null) {
			if (other.pkprofessor != null)
				return false;
		} else if (!pkprofessor.equals(other.pkprofessor))
			return false;
		return true;
	}

}
