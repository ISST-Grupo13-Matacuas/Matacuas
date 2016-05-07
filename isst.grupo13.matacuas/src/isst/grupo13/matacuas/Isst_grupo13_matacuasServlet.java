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
public class Isst_grupo13_matacuasServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
    
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		String user = "";
		if(req.getUserPrincipal()!=null){
			user = req.getUserPrincipal().getName();
			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Logout";
			
			
		}
		
		
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		UsuarioDAO daoUsuario = UsuarioDAOImp.getInstance();
		List<Queja> quejas = dao.read();
		
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);
		
		if(user!=""){
			List<Usuario> usuarios = daoUsuario.readUsuario(user);
			Usuario usuario = null;
			if(usuarios.size() == 0){
				usuario = daoUsuario.create(user, "", "", 0,"");
				req.getSession().setAttribute("usuarioBD", usuario);
			}
			else{
				usuario = usuarios.get(0);
				req.getSession().setAttribute("usuarioBD", usuario);
			}
			String matricula = usuario.getMatricula();
			int tipo = usuario.getTipo();
			List<Queja> quejasMatricula = dao.readMatricula(matricula);
			int longitud = quejasMatricula.size();
			req.getSession().setAttribute("quejasMatricula", new ArrayList<Queja>(quejasMatricula));
			req.getSession().setAttribute("notificaciones", longitud);
			req.getSession().setAttribute("tipoUsuario", tipo);
		}
		
		
		req.getSession().setAttribute("quejas", new ArrayList<Queja>(quejas));
		
			RequestDispatcher view = req.getRequestDispatcher("SingleApp.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}
}
