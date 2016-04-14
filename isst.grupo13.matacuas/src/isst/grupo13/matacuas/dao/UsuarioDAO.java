package isst.grupo13.matacuas.dao;

import java.util.List;

import isst.grupo13.matacuas.model.Usuario;

public interface UsuarioDAO {
	public Usuario create(String usuario, String matricula, String nick, int tipo);
	
	//Saca todas los usuarios almacenados
	public List<Usuario> read();
	
	//Busca un usuario por su email 
	public List<Usuario> readUsuario(String usuario);
	
	//Busca un usuario por su matricula
	public List<Usuario> readMatricula(String matricula);
	
	//Busca un usuario por su nick
	public List<Usuario> nick(String nick);
	
	//Actualiza un usuario (nick,matricula)
	public void update(Usuario usuario);
	
	//Borra un usuario
	public void delete(Usuario usuario);
	

}
