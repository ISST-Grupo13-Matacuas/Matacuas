package isst.grupo13.matacuas;


import isst.grupo13.matacuas.dao.UsuarioDAO;
import isst.grupo13.matacuas.dao.UsuarioDAOImp;
import isst.grupo13.matacuas.model.Usuario;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;



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
		//System.out.println(nick);
		String matricula = req.getParameter("matricula");
		Map<String, List<BlobKey>> blobs = BlobstoreServiceFactory.getBlobstoreService().getUploads(req);
		List<BlobKey> blobKeys = blobs.get("imagenPerfil");
		System.out.println(blobs.get("imagenPerfil"));
		String imagen = "";
		if ( blobKeys == null || blobKeys.isEmpty() || blobKeys .get(0) == null ) {
			imagen = "";
		}
		else{
			imagen = blobKeys.get(0).getKeyString();
			System.out.println(imagen);
		}
		UsuarioDAO daoUser = UsuarioDAOImp.getInstance();
		Usuario usuarioBD = (Usuario) req.getSession().getAttribute("usuarioBD");
		Usuario usuario = daoUser.readUsuarioId(usuarioBD.getId());
		List<Usuario> repetido = daoUser.readMatricula(matricula);
		if(nick != ""  && matricula != "" && repetido.isEmpty() && imagen != ""){
			usuario.setNick(nick);
			usuario.setMatricula(matricula);
			usuario.setImagen(imagen);
		}
		
		daoUser.update(usuario);
		req.getSession().setAttribute("usuarioBD", usuario);
		resp.sendRedirect("/matacuas");
		
	}
	
	
}