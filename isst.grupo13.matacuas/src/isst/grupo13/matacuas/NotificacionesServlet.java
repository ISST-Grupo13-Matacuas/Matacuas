package isst.grupo13.matacuas;
import isst.grupo13.matacuas.dao.QuejaDAO;
import isst.grupo13.matacuas.dao.QuejaDAOImpl;
import isst.grupo13.matacuas.dao.UsuarioDAO;
import isst.grupo13.matacuas.dao.UsuarioDAOImp;
import isst.grupo13.matacuas.model.Queja;
import isst.grupo13.matacuas.model.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class NotificacionesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Usuario usuarioBD = (Usuario) req.getSession().getAttribute("usuarioBD");
		String matricula = usuarioBD.getMatricula();
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		List<Queja> quejasMatricula = dao.readMatricula(matricula);
		int longitud = quejasMatricula.size();
		req.getSession().setAttribute("notificaciones", longitud);
		req.getSession().setAttribute("quejasMatricula", new ArrayList<Queja>(quejasMatricula));
		
		RequestDispatcher view = req.getRequestDispatcher("Notificaciones.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
