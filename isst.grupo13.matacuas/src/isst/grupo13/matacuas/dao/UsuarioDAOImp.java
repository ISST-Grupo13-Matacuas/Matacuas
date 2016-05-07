package isst.grupo13.matacuas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import isst.grupo13.matacuas.model.Queja;
import isst.grupo13.matacuas.model.Usuario;
import isst.grupo13.matacuas.model.Usuario;
import isst.grupo13.matacuas.model.Usuario;

public class UsuarioDAOImp implements UsuarioDAO{
	
	//Patrón Singleton
		private static UsuarioDAOImp instance;
		
		private UsuarioDAOImp() {
			// TODO Auto-generated constructor stub
		}
		
		public static UsuarioDAOImp getInstance(){
			if (instance == null){
				instance = new UsuarioDAOImp();
				
			}
			return instance;
		}

	@Override
	public Usuario create(String usuario, String matricula, String nick, int tipo,String imagen) {
		Usuario usr = null;
		EntityManager em = EMFService.get().createEntityManager();
		usr = new Usuario(usuario, matricula, nick, tipo,imagen);
		em.persist(usr);
		em.close();
		
		return usr;
	}

	@Override
	public List<Usuario> read() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from Usuario m");
		List<Usuario> res = q.getResultList();
		em.close();
		return res;
	}
	
	@Override
	public Usuario readUnUsuario(String usuario) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select q from Usuario q where q.usuario = :usuario");
		q.setParameter("usuario", usuario);
		Usuario unUsuario = new Usuario("", "", "", 0, "");
		try{
			unUsuario = (Usuario) q.getResultList().get(0);
		}finally{		
			em.close();
		}
		
		return unUsuario;
	}

	@Override
	public List<Usuario> readUsuario(String usuario) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select q from Usuario q where q.usuario = :usuario");
		q.setParameter("usuario", usuario);
		List<Usuario> usuarios = q.getResultList();
		em.close();
		return usuarios;
	}

	@Override
	public List<Usuario> readMatricula(String matricula) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select q from Usuario q where q.matricula = :matricula");
		q.setParameter("matricula", matricula);
		List<Usuario> usuarios = q.getResultList();
		em.close();
		return usuarios;
	}

	@Override
	public List<Usuario> nick(String nick) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select q from Usuario q where q.nick = :nick");
		q.setParameter("nick", nick);
		List<Usuario> usuarios = q.getResultList();
		em.close();
		return usuarios;
	}
	
	@Override
	public Usuario readNick(String nick){
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select q from Usuario q where q.nick = :nick");
		q.setParameter("nick", nick);
		Usuario usuario = (Usuario) q.getResultList().get(0);
		em.close();
		return usuario;
	}

	@Override
	public void update(Usuario usuario) {
		EntityManager em = EMFService.get().createEntityManager();
		em.merge(usuario);
		em.close();
		
	}

	@Override
	public void delete(Usuario usuario) {
		EntityManager em = EMFService.get().createEntityManager();
		
		try{
			Usuario busq = em.find(Usuario.class, usuario.getId());
			em.remove(busq);
			
		}
		finally{
		
			em.close();
		}
		
	}
	
	public Usuario readUsuarioId(Long id){
		EntityManager em = EMFService.get().createEntityManager();
		Usuario usuario = em.find(Usuario.class, id);
		em.close();
		return usuario;
	}
	

}
