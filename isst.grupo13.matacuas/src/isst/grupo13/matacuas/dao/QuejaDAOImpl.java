/**
 * 
 */
package isst.grupo13.matacuas.dao;

import isst.grupo13.matacuas.model.Queja;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import isst.grupo13.matacuas.dao.EMFService;




/**
 * @author Carlos
 *
 */
public class QuejaDAOImpl implements QuejaDAO {
	
	
	//Patrón Singleton
	private static QuejaDAOImpl instance;
	
	private QuejaDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static QuejaDAOImpl getInstance(){
		if (instance == null){
			instance = new QuejaDAOImpl();
			
		}
		return instance;
	}
	
	

	/* (non-Javadoc)
	 * @see isst.grupo13.matacuas.dao.QuejaDAO#create(java.lang.String, java.lang.String, java.lang.String, java.lang.String, double, double, java.lang.String, int)
	 */
	@Override
	public Queja create(String usuario, String matricula, String lugar,
			String descripcion, double lat, double lng, String imagen,
			int estado) {
		Queja queja = null;
		EntityManager em = EMFService.get().createEntityManager();
		queja = new Queja(usuario, matricula, lugar, descripcion, lat, lng, imagen, estado);
		em.persist(queja);
		em.close();
		
		return queja;
	}

	/* (non-Javadoc)
	 * @see isst.grupo13.matacuas.dao.QuejaDAO#read()
	 */
	@Override
	public List<Queja> read() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from Queja m");
		List<Queja> res = q.getResultList();
		em.close();
		return res;
	}

	/* (non-Javadoc)
	 * @see isst.grupo13.matacuas.dao.QuejaDAO#readUsuario(java.lang.String)
	 */
	@Override
	public List<Queja> readUsuario(String usuario) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select t from Queja q where q.usuario = :usuario");
		q.setParameter("usuario", usuario);
		List<Queja> quejas = q.getResultList();
		em.close();
		return quejas;
	}

	/* (non-Javadoc)
	 * @see isst.grupo13.matacuas.dao.QuejaDAO#readMatricula(java.lang.String)
	 */
	@Override
	public List<Queja> readMatricula(String matricula) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select t from Queja q where q.matricula = :matricula");
		q.setParameter("matricula", matricula);
		List<Queja> quejas = q.getResultList();
		em.close();
		return quejas;
	}

	/* (non-Javadoc)
	 * @see isst.grupo13.matacuas.dao.QuejaDAO#readEstado(int)
	 */
	@Override
	public List<Queja> readEstado(int estado) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select t from Queja q where q.estado = :estado");
		q.setParameter("estado", estado);
		List<Queja> quejas = q.getResultList();
		em.close();
		return quejas;
	}

	/* (non-Javadoc)
	 * @see isst.grupo13.matacuas.dao.QuejaDAO#update(isst.grupo13.matacuas.model.Queja)
	 */
	@Override
	public void update(Queja queja) {
		// TODO Auto-generated method stub
		EntityManager em = EMFService.get().createEntityManager();
		em.merge(queja);
		em.close();
	}

	/* (non-Javadoc)
	 * @see isst.grupo13.matacuas.dao.QuejaDAO#delete(isst.grupo13.matacuas.model.Queja)
	 */
	@Override
	public void delete(Queja queja) {
		EntityManager em = EMFService.get().createEntityManager();
		
		try{
			Queja busq = em.find(Queja.class, queja.getUsuario());
			em.remove(busq);
			
		}
		finally{
		
			em.close();
		}

	}

}
