package isst.grupo13.matacuas;

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

public class BorrarQuejaServlet extends HttpServlet{

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		UsuarioDAO daoUsuario = UsuarioDAOImp.getInstance();
		
		Queja queja = dao.readQuejaId(id);
		String email = queja.getUsuario();
		Usuario us = daoUsuario.readUnUsuario(email);
		int quejasBorradas = us.getQuejasBorradas();
		
		String user = (String) req.getSession().getAttribute("user");

		if(user!=""){
			quejasBorradas++;
			us.setQuejasBorradas(quejasBorradas);
			daoUsuario.update(us);
			dao.delete(queja);
		}
		
		resp.sendRedirect("/matacuas");
				
		
	}

	
}
