package isst.grupo13.matacuas.dao;

import java.util.List;

import isst.grupo13.matacuas.model.Usuario;

public interface UsuarioDAO {
	public Usuario create(String usuario, String matricula, String nick);
	
	//Saca todas las quejas almacenadas
	public List<Usuario> read();
	
	//Saca todas las quejas que ha puesto un usuario
	public List<Usuario> readUsuario(String usuario);
	
	//Saca todas las quejas asociadas a una matricula
	public List<Usuario> readMatricula(String matricula);
	
	public List<Usuario> nick(String nick);
	
	//Actualiza una queja (estado)
	public void update(Usuario usuario);
	
	//Borra una queja
	public void delete(Usuario usuario);
}
