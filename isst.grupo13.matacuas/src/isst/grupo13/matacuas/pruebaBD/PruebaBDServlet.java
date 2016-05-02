package isst.grupo13.matacuas.pruebaBD;
import isst.grupo13.matacuas.dao.QuejaDAO;
import isst.grupo13.matacuas.dao.QuejaDAOImpl;
import isst.grupo13.matacuas.dao.ReclamacionDAO;
import isst.grupo13.matacuas.dao.ReclamacionDAOImpl;
import isst.grupo13.matacuas.dao.UsuarioDAO;
import isst.grupo13.matacuas.dao.UsuarioDAOImp;
import isst.grupo13.matacuas.model.Queja;
import isst.grupo13.matacuas.model.Reclamacion;
import isst.grupo13.matacuas.model.Usuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class PruebaBDServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.getWriter().println("<h1>Prueba de base de datos</h1>");
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		UsuarioDAO daoUser = UsuarioDAOImp.getInstance();
		ReclamacionDAO daoRecl = ReclamacionDAOImpl.getInstance();
		List<Usuario> usuarios = daoUser.read();
		
		List<Queja> quejas = dao.read();
		if (quejas.size() == 0  ){
			Queja queja1 =  dao.create("charlygs94@gmail.com", "7952HWT", "Calle Murillo", "Choque con otro vehiculo", 4924504.28315, -421356.21759, null, 1,1);
			Queja queja2 =  dao.create("charlygs94@gmail.com", "4675DVD", "Príncipe Pío", "Ha hecho un ceda al paso correctamente", 4927313.34394, -414204.57813, null, 1,2);
			Queja queja3 =  dao.create("charlygs94@gmail.com", "4675DVD", "Complutense", "Ha evitado un accidente", 4931584, -414897, null, 1,2);
			
		}
		
		if (usuarios.size() == 0){
			Usuario usuario1 = daoUser.create("charlygs94@gmail.com", "6784HWT", "gscharly",0);
			Usuario moderador = daoUser.create("g.carreto@gmail.com", "8594FBH", "g.carreto",1);
			
		}
		
		/*Queja quejaPrueba = dao.readUsuario("charlygs94@gmail.com").get(0);
		Reclamacion recl = daoRecl.create("Yo no pude ser.", "No he pasado por  ahi nunca.", quejaPrueba.getId());
		//recl.setQueja(quejaPrueba);
		//daoRecl.update(recl);
		resp.getWriter().println("Base Reclamaciones:");
		resp.getWriter().println(recl);
		resp.getWriter().println("<br>");*/
		
		/*
		List<Queja> quejasMalas = dao.read();
		for(Queja quejaMala:quejasMalas){
			dao.delete(quejaMala);
		}*/
		//dao.delete(queja1);
		//dao.delete(queja2);
	
		
		resp.getWriter().println("Base Quejas:");
		resp.getWriter().println("<br>");
		//resp.getWriter().println(queja1);
		for(Queja queja:dao.read()){
			resp.getWriter().println(queja.getId() + " " + queja);
			resp.getWriter().println("<br>");
		}
		
		resp.getWriter().println("Base Reclamaciones:");
		resp.getWriter().println("<br>");
		for(Reclamacion recl:daoRecl.read()){
			resp.getWriter().println(recl.getId() + " " + recl);
			resp.getWriter().println("<br>");
		}
		
		resp.getWriter().println("Base Usuarios:");
		resp.getWriter().println("<br>");
		for(Usuario usuario:daoUser.read()){
			resp.getWriter().println(usuario.getId() + " " + usuario);
			resp.getWriter().println("<br>");
		}
		
		resp.getWriter().println("Usuario:");
		resp.getWriter().println("<br>");
		for(Queja queja:dao.readUsuario("charlygs94@gmail.com")){
			resp.getWriter().println(queja);
			resp.getWriter().println("<br>");
		}
		resp.getWriter().println("Matrícula:");
		resp.getWriter().println("<br>");
		for(Queja queja:dao.readMatricula("7952HWT")){
			resp.getWriter().println(queja);
			resp.getWriter().println("<br>");
		}
		resp.getWriter().println("Estado:");
		resp.getWriter().println("<br>");
		for(Queja queja:dao.readEstado(1)){
			resp.getWriter().println(queja);
			resp.getWriter().println("<br>");
		}
	}
}