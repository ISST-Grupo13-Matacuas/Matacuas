package isst.grupo13.matacuas;

import isst.grupo13.matacuas.dao.UsuarioDAO;
import isst.grupo13.matacuas.dao.UsuarioDAOImp;
import isst.grupo13.matacuas.model.Usuario;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BanearServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String email = (String) req.getParameter("email");
		UsuarioDAO daoUser = UsuarioDAOImp.getInstance();
		Usuario us = daoUser.readUnUsuario(email);
		int decision = Integer.parseInt(req.getParameter("decision"));
		System.out.println(decision);
		if(decision == 0){
			us.setBaneado(true);
			daoUser.update(us);
		}
		else if(decision == 1){
			us.setBaneado(false);
			daoUser.update(us);
		}
		
		resp.sendRedirect("/listaUsuarios");
	}

}
