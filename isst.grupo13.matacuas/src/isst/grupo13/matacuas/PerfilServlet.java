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

@SuppressWarnings("serial")
public class PerfilServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String usuario =  (String) req.getSession().getAttribute("user");
		//String usuarioBD = (String) req.getSession().getAttribute("usuarioBD");
		//UsuarioDAO daoUser = UsuarioDAOImp.getInstance();
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		List<Queja> quejasUsuario = dao.readUsuario(usuario);
		
		//List<Usuario> usuarios = daoUser.readUsuario(usuario);
		//Usuario usuarioPrincipal = usuarios.get(0);
		//req.setAttribute("quejasUsuario", quejasUsuario);
		//req.setAttribute("usuarioPrincipal", usuarioPrincipal);
		//req.setAttribute("usuarios", usuarios);
		req.getSession().setAttribute("quejasUsuario",new ArrayList<Queja>(quejasUsuario) );
		RequestDispatcher view = req.getRequestDispatcher("Perfil.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}