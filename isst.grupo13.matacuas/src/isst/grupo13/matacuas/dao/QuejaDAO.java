package isst.grupo13.matacuas.dao;

import java.util.List;

import isst.grupo13.matacuas.model.Queja;
import isst.grupo13.matacuas.model.Usuario;

public interface QuejaDAO {
	
	//Crea una nueva queja y la guarda en la BD
	public Queja create(String usuario, String matricula, String lugar, String descripcion, double lat, double lng,
			String imagen, int estado, int tipo);
	
	//Saca todas las quejas almacenadas
	public List<Queja> read();
	
	//Saca todas las quejas que ha puesto un usuario
	public List<Queja> readUsuario(String usuario);
	
	//Saca todas las quejas asociadas a una matricula
	public List<Queja> readMatricula(String matricula);
	
	//Devuelve las quejas en el mismo estado
	public List<Queja> readEstado(int estado);
	
	//Actualiza una queja (estado)
	public void update(Queja queja);
	
	//Borra una queja
	public void delete(Queja queja);
	//Buscar una queja por su id
	public Queja readQuejaId(Long id);

}
