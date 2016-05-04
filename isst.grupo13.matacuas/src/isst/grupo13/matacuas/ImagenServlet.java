package isst.grupo13.matacuas;

import isst.grupo13.matacuas.dao.QuejaDAO;
import isst.grupo13.matacuas.dao.QuejaDAOImpl;
import isst.grupo13.matacuas.model.Queja;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreInputStream;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;



@SuppressWarnings("serial")
public class ImagenServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		Queja queja = dao.readQuejaId(id);
		BlobKey blobKey = new BlobKey( queja.getImagen());
		//BlobstoreInputStream is =new BlobstoreInputStream(blobKey);
		BlobstoreService blobStore = BlobstoreServiceFactory.getBlobstoreService();
		//blobStore= BlobstoreServiceFactory.getBlobstoreService();
		blobStore.serve(blobKey, resp);
		//BlobstoreInputStream is =new BlobstoreInputStream(blobKey);
		//OutputStream output = resp.getOutputStream();
		//resp.setContentType("image/gif");
		
	}
}