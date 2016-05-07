package isst.grupo13.matacuas;


import isst.grupo13.matacuas.model.Usuario;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.blobstore.BlobKey;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;



@SuppressWarnings("serial")
public class ImagenUsuarioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioBD");
		BlobKey blobKey = new BlobKey( usuario.getImagen());
		BlobstoreService blobStore = BlobstoreServiceFactory.getBlobstoreService();
		blobStore.serve(blobKey, resp);
		
		
	}
	
}

