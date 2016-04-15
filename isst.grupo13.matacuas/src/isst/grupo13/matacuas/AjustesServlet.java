package isst.grupo13.matacuas;


import isst.grupo13.matacuas.dao.UsuarioDAO;
import isst.grupo13.matacuas.dao.UsuarioDAOImp;
import isst.grupo13.matacuas.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;



@SuppressWarnings("serial")
public class AjustesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		RequestDispatcher view = req.getRequestDispatcher("Ajustes.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String nick = req.getParameter("nick");
		String matricula = req.getParameter("matricula");
		UsuarioDAO daoUser = UsuarioDAOImp.getInstance();
		Usuario usuarioBD = (Usuario) req.getSession().getAttribute("usuarioBD");
		Usuario usuario = daoUser.readUsuarioId(usuarioBD.getId());
		if(nick != "" && matricula != ""){
			usuario.setNick(nick);
			usuario.setMatricula(matricula);
		}
		
		daoUser.update(usuario);
		req.getSession().setAttribute("usuarioBD", usuario);
		RequestDispatcher view = req.getRequestDispatcher("Perfil.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}