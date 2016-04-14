package isst.grupo13.matacuas;

import isst.grupo13.matacuas.dao.QuejaDAO;
import isst.grupo13.matacuas.dao.QuejaDAOImpl;
import isst.grupo13.matacuas.model.Queja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class VerQuejaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		//Queja queja =  req.getSession().getAttribute("queja");
		Queja queja1 = (Queja) req.getAttribute("queja");
		//resp.getWriter().println(queja);
		resp.getWriter().println(queja1);
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		//Queja queja = dao.find(Queja.class, id);
		
	}
	
}