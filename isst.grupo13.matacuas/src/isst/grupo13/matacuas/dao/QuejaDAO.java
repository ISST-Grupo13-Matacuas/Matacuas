package isst.grupo13.matacuas.dao;

import java.util.List;

import isst.grupo13.matacuas.model.Queja;
import isst.grupo13.matacuas.model.Usuario;
import com.google.appengine.api.datastore.Text;

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
	
	//Devuelve las quejas o felicitaciones segun se pase el tipo y por matricula
	public List<Queja> readQuejaMatriculaTipo(String matricula, int tipo);
	
	//Devuelve las quejas según lugar
	public List<Queja> readLugar(String lugar);
	
	//Busca en la descripcion
	public List<Queja> readDescripcion(String descripcion);
	
	//Busca según sea buena o mala
	public List<Queja> readTipo(int tipo);
	
	//Actualiza una queja (estado)
	public void update(Queja queja);
	
	//Borra una queja
	public void delete(Queja queja);
	//Buscar una queja por su id
	public Queja readQuejaId(Long id);

}
