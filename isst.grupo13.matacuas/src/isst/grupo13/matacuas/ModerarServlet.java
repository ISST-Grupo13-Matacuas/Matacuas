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

@SuppressWarnings("serial")
public class ModerarServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		ReclamacionDAO daoRecl = ReclamacionDAOImpl.getInstance();
		List<Reclamacion> reclamaciones = daoRecl.read();
		List<Queja> quejasReclamadas = dao.readEstado(2); //Deber�an de ser lo mismo
		req.setAttribute("reclamaciones", reclamaciones);
		req.setAttribute("quejasReclamadas", quejasReclamadas);
		RequestDispatcher view = req.getRequestDispatcher("Moderar.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));
		int result = Integer.parseInt(req.getParameter("result"));

		if(id != null){
			
			QuejaDAO dao = QuejaDAOImpl.getInstance();
			ReclamacionDAO daoRecl = ReclamacionDAOImpl.getInstance();
			Queja queja = dao.readQuejaId(id);
			Reclamacion reclamacion = daoRecl.readQueja(id);
			UsuarioDAO daoUser = UsuarioDAOImp.getInstance();

			queja.setEstado(result);
			dao.update(queja);
			daoRecl.delete(reclamacion);
			
			if(result == 3){
				
				String matricula = queja.getMatricula();
				Usuario us = daoUser.readMatricula(matricula);
				int recl = us.getReclamacionesRechazadas();
				recl++;
				us.setReclamacionesRechazadas(recl);
				daoUser.update(us);
			}
			
		
			
		}else{

		}
		resp.sendRedirect("/matacuas");
		/*RequestDispatcher view = req.getRequestDispatcher("Moderar.jsp");
		
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		}*/
		
		
	}

}
