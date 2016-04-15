package isst.grupo13.matacuas;
import isst.grupo13.matacuas.dao.QuejaDAO;
import isst.grupo13.matacuas.dao.QuejaDAOImpl;
import isst.grupo13.matacuas.dao.UsuarioDAO;
import isst.grupo13.matacuas.dao.UsuarioDAOImp;
import isst.grupo13.matacuas.model.Queja;
import isst.grupo13.matacuas.model.Usuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ReclamarServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));
		//resp.getWriter().println(id);
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		Queja queja = dao.readQuejaId(id);
		queja.setEstado(2);
		dao.update(queja);
	}
}