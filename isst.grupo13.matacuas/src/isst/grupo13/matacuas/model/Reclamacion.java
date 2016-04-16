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
	
	
	
}
