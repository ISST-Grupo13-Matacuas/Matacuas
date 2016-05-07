package isst.grupo13.matacuas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@SequenceGenerator(name="seq",initialValue=1)

@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 01L;
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private Long id;
	private String usuario; //Correo del usuario
	private String matricula;  //Matricula del coche del usuario
	private String nick; //Apodo del usuario
	private int tipo; //Moderador o no
	private String imagen;
	
		
	public Usuario(String usuario, String matricula, String nick, int tipo,String imagen) {
		super();
		
		this.usuario = usuario;
		this.matricula = matricula;
		this.nick = nick;
		this.tipo=tipo;
		this.imagen = imagen;
	}
	
	
	
	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}



	public String getImagen() {
		return imagen;
	}



	public void setImagen(String imagen) {
		this.imagen = imagen;
	}



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", matricula="
				+ matricula + ", nick=" + nick + ", tipo=" + tipo + ", imagen="
				+ imagen + "]";
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		if (tipo != other.tipo)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}



	
	
	

}
