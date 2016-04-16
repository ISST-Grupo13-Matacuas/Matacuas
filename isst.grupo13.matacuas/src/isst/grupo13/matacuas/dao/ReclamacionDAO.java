package isst.grupo13.matacuas.dao;

import java.util.List;

import isst.grupo13.matacuas.model.Queja;
import isst.grupo13.matacuas.model.Reclamacion;

public interface ReclamacionDAO {
	
	public Reclamacion create(String descripcion, String razon, Long idQueja);
	public List<Reclamacion> read();
	public Reclamacion readQueja(Long idQueja);
	public void update(Reclamacion recl);
	public void delete(Reclamacion recl);

}
