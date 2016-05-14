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
	private boolean baneado;
	private int reclamacionesRechazadas;
	private int quejasBorradas;
	
		
	public Usuario(String usuario, String matricula, String nick, int tipo,String imagen, boolean baneado, int recl, int quej) {
		super();
		
		this.usuario = usuario;
		this.matricula = matricula;
		this.nick = nick;
		this.tipo=tipo;
		this.imagen = imagen;
		this.baneado = baneado;
		this.reclamacionesRechazadas = recl;
		this.quejasBorradas = quej;
	}
	
	
	
	
	public int getReclamacionesRechazadas() {
		return reclamacionesRechazadas;
	}




	public void setReclamacionesRechazadas(int reclamacionesRechazadas) {
		this.reclamacionesRechazadas = reclamacionesRechazadas;
	}




	public int getQuejasBorradas() {
		return quejasBorradas;
	}




	public void setQuejasBorradas(int quejasBorradas) {
		this.quejasBorradas = quejasBorradas;
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




	public boolean isBaneado() {
		return baneado;
	}




	public void setBaneado(boolean baneado) {
		this.baneado = baneado;
	}




	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", matricula="
				+ matricula + ", nick=" + nick + ", tipo=" + tipo + ", imagen="
				+ imagen + ", baneado=" + baneado
				+ ", reclamacionesRechazadas=" + reclamacionesRechazadas
				+ ", quejasBorradas=" + quejasBorradas + "]";
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
		if (baneado != other.baneado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
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
		if (quejasBorradas != other.quejasBorradas)
			return false;
		if (reclamacionesRechazadas != other.reclamacionesRechazadas)
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
