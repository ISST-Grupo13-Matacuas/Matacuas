package isst.grupo13.matacuas.dao;

import isst.grupo13.matacuas.model.Queja;
import isst.grupo13.matacuas.model.Reclamacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ReclamacionDAOImpl implements ReclamacionDAO {

	//Patrón Singleton
		private static ReclamacionDAOImpl instance;
		
		private ReclamacionDAOImpl() {
			// TODO Auto-generated constructor stub
		}
		
		public static ReclamacionDAOImpl getInstance(){
			if (instance == null){
				instance = new ReclamacionDAOImpl();
				
			}
			return instance;
		}
	
	@Override
	public Reclamacion create(String descripcion, String razon, Long idQueja) {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		Reclamacion reclamacion =  new Reclamacion(descripcion,razon, idQueja);
		em.persist(reclamacion);
		em.close();
		return reclamacion;
	}

	@Override
	public List<Reclamacion> read() {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from Reclamacion m");
		List<Reclamacion> res = q.getResultList();
		em.close();
		return res;
		
	}

	@Override
	public Reclamacion readQueja(Long idQueja) {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select q from Reclamacion q where q.idQueja = :idQueja");
		q.setParameter("idQueja", idQueja);
		Reclamacion res = (Reclamacion) q.getSingleResult();
		return res;
	}
	
	public void update(Reclamacion recl){
		EntityManager em = EMFService.get().createEntityManager();
		em.merge(recl);
		em.close();
		
	}
	public void delete(Reclamacion recl){
		EntityManager em = EMFService.get().createEntityManager();
		
		try{
			Reclamacion busq = em.find(Reclamacion.class, recl.getId());
			em.remove(busq);
			
		}
		finally{
		
			em.close();
		}
		
	}

}
