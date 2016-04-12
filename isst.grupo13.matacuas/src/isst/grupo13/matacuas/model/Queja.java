package isst.grupo13.matacuas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Carlos Gomez Sanchez
 *
 */
@SequenceGenerator(name="seq",initialValue=1)

@Entity
public class Queja implements Serializable {
	
	private static final long serialVersionUID = 01L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private Long id;
	private String usuario; //Usuario que pone la queja
	private String matricula;  //Matricula del coche infractor
	private String lugar; //Nombre del lugar, calle, lugares cercanos...
	private String descripcion; //Descripción del incidente
	private double lat; //Latitud
	private double lng; //Longitud
	private String imagen; //Imagen si ha podido hacerla, si no por defecto
	private int estado; //Para moderadores, reclamaciones
	
	
	public Queja(String usuario, String matricula, String lugar, String descripcion, double lat, double lng,
			String imagen, int estado) {
		super();
		this.usuario = usuario;
		this.matricula = matricula;
		this.lugar = lugar;
		this.descripcion = descripcion;
		this.lat = lat;
		this.lng = lng;
		this.imagen = imagen;
		this.estado = estado;
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLng() {
		return lng;
	}


	public void setLng(double lng) {
		this.lng = lng;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return "Queja [usuario=" + usuario + ", matricula=" + matricula
				+ ", lugar=" + lugar + ", descripcion=" + descripcion
				+ ", lat=" + lat + ", lng=" + lng + ", imagen=" + imagen
				+ ", estado=" + estado + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Queja other = (Queja) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado != other.estado)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		if (lugar == null) {
			if (other.lugar != null)
				return false;
		} else if (!lugar.equals(other.lugar))
			return false;
		return true;
	}
	
	
	
	

}
