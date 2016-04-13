package isst.grupo13.matacuas;

import isst.grupo13.matacuas.dao.QuejaDAO;
import isst.grupo13.matacuas.dao.QuejaDAOImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;



@SuppressWarnings("serial")
public class NuevaQuejaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		/*UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		String user = "";
		if(req.getUserPrincipal()!=null){
			user = req.getUserPrincipal().getName();
			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Logout";
			//resp.getWriter().println( "<p>Hola " + req.getUserPrincipal().getName() + "</p>");
			
		}
		
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);*/
		
		String tipo = req.getParameter("tipo");
		req.getSession().setAttribute("tipoQueja", tipo);
		
		//resp.getWriter().println(tipo);
		RequestDispatcher view = req.getRequestDispatcher("NewQueja.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		String usuario = (String) req.getSession().getAttribute("usuario");
		String lugar = req.getParameter("lugar");
		String matricula = req.getParameter("matricula");
		String descripcion = req.getParameter("descripcion");
		String lat =  req.getParameter("latitud");
		String lng = req.getParameter("longitud");
		
		if(lugar!= null && matricula!= null && descripcion != null && usuario!= "" && lat!=null && lng != null){
			QuejaDAO dao = QuejaDAOImpl.getInstance();
			//Queja queja = dao.create()
		}
	}
}