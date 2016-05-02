/**
 * 
 */
package isst.grupo13.matacuas.dao;

import isst.grupo13.matacuas.model.Queja;
import isst.grupo13.matacuas.model.Usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.appengine.api.datastore.Text;

import isst.grupo13.matacuas.dao.EMFService;




/**
 * @author Carlos
 *
 */
public class QuejaDAOImpl implements QuejaDAO {
	
	
	//Patr�n Singleton
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
			String descripcion, double lat, double lng, Text imagen,
			int estado, int tipo) {
		Queja queja = null;
		EntityManager em = EMFService.get().createEntityManager();
		queja = new Queja(usuario, matricula, lugar, descripcion, lat, lng, imagen, estado, tipo);
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
		Query q = em.createQuery("select q from Queja q where q.usuario = :usuario");
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
		Query q = em.createQuery("select q from Queja q where q.matricula = :matricula");
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
		Query q = em.createQuery("select q from Queja q where q.estado = :estado");
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
			Queja busq = em.find(Queja.class, queja.getId());
			em.remove(busq);
			
		}
		finally{
		
			em.close();
		}

	}
	
	public Queja readQuejaId(Long id){
		EntityManager em = EMFService.get().createEntityManager();
		Queja queja = em.find(Queja.class, id);
		em.close();
		return queja;
	}

	@Override
	public List<Queja> readQuejaMatriculaTipo(String matricula, int tipo) {
		EntityManager em = EMFService.get().createEntityManager();
		//Query q = em.createQuery("select q from Queja q where q.tipo = :tipo and q.matricula = :matricula");
		//q.setParameter("tipo", tipo);
		
		Query q = em.createQuery("select q from Queja q where q.matricula = :matricula and q.tipo = :tipo");
		//Query q = em.createQuery("select q from Queja q where q.tipo = :tipo");
		//q.setParameter("tipo", tipo).setParameter("matricula", matricula);
		//q.setParameter("tipo", 0);
		System.out.println(tipo);
		q.setParameter("matricula", matricula).setParameter("tipo", tipo);
		List<Queja> quejas = q.getResultList();
		System.out.println("quejas");
		System.out.println(quejas);
		em.close();
		return quejas;
	}

}
