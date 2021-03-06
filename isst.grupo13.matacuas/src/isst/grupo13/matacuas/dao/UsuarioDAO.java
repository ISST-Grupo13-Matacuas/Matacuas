package isst.grupo13.matacuas.dao;

import java.util.List;

import isst.grupo13.matacuas.model.Usuario;

public interface UsuarioDAO {
	public Usuario create(String usuario, String matricula, String nick, int tipo,String imagen,boolean baneado, int recl, int quej);
	
	//Saca todas los usuarios almacenados
	public List<Usuario> read();
	
	//Busca un usuario por su email 
	public List<Usuario> readUsuario(String usuario);
	
	public Usuario readUnUsuario(String usuario);
	
	//Busca un usuario por su matricula
	public Usuario readMatricula(String matricula);
	
	//Busca un usuario por su nick
	public List<Usuario> nick(String nick);
	
	public Usuario readNick(String nick);
	
	//Actualiza un usuario (nick,matricula)
	public void update(Usuario usuario);
	
	//Borra un usuario
	public void delete(Usuario usuario);
	
	public Usuario readUsuarioId(Long id);
	

}
