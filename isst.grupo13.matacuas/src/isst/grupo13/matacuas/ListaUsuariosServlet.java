package isst.grupo13.matacuas;

import isst.grupo13.matacuas.dao.UsuarioDAO;
import isst.grupo13.matacuas.dao.UsuarioDAOImp;
import isst.grupo13.matacuas.model.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ListaUsuariosServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioBD");
		//Si es moderador
		if (usuario.getTipo() == 1){
			UsuarioDAO daoUsuario = UsuarioDAOImp.getInstance();
			List<Usuario> usuarios = daoUsuario.read();
			req.setAttribute("usuariosSistema",new ArrayList<Usuario>(usuarios));
			RequestDispatcher view = req.getRequestDispatcher("ListaUsuarios.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			RequestDispatcher view = req.getRequestDispatcher("Error.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	}