package isst.grupo13.matacuas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@SequenceGenerator(name="seq",initialValue=1)

@Entity
public class Reclamacion implements Serializable {
	private static final long serialVersionUID = 01L;
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private Long id;
	private String descripcion;
	private String razon;

	private Long idQueja;
	
	
	
	
	public Reclamacion(String descripcion, String razon, Long idQueja) {
		super();
		this.descripcion = descripcion;
		this.razon = razon;
		this.idQueja = idQueja;
		
	}
	
	
	
	
	


	


	@Override
	public String toString() {
		return "Reclamacion [id=" + id + ", descripcion=" + descripcion
				+ ", razon=" + razon + ", idQueja=" + idQueja + "]";
	}










	public Long getIdQueja() {
		return idQueja;
	}


	public void setIdQueja(Long idQueja) {
		this.idQueja = idQueja;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRazon() {
		return razon;
	}
	public void setRazon(String razon) {
		this.razon = razon;
	}












	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reclamacion other = (Reclamacion) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idQueja == null) {
			if (other.idQueja != null)
				return false;
		} else if (!idQueja.equals(other.idQueja))
			return false;
		if (razon == null) {
			if (other.razon != null)
				return false;
		} else if (!razon.equals(other.razon))
			return false;
		return true;
	}
	
	
	
}
