package isst.grupo13.matacuas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import isst.grupo13.matacuas.model.Queja;
import isst.grupo13.matacuas.model.Usuario;
import isst.grupo13.matacuas.model.Usuario;
import isst.grupo13.matacuas.model.Usuario;

public class UsuarioDAOImp implements UsuarioDAO{

	@Override
	public Usuario create(String usuario, String matricula, String nick) {
		Usuario usr = null;
		EntityManager em = EMFService.get().createEntityManager();
		usr = new Usuario(usuario, matricula, nick);
		em.persist(usuario);
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

}
