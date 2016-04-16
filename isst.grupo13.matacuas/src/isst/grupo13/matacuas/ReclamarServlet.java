package isst.grupo13.matacuas;


import isst.grupo13.matacuas.dao.QuejaDAO;
import isst.grupo13.matacuas.dao.QuejaDAOImpl;
import isst.grupo13.matacuas.model.Queja;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ReclamarServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		//Long id = Long.parseLong(req.getParameter("id"));
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		
		RequestDispatcher view = req.getRequestDispatcher("Reclamar.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//resp.getWriter().println(id);
		//QuejaDAO dao = QuejaDAOImpl.getInstance();
		//Queja queja = dao.readQuejaId(id);
		//queja.setEstado(2);
		//dao.update(queja);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String razon = req.getParameter("razon");
		
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		Queja queja = dao.readQuejaId(id);
		queja.setEstado(2);
		dao.update(queja);
		resp.sendRedirect("/matacuas");
		
	}
}