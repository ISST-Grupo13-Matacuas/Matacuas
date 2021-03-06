package isst.grupo13.matacuas;

import isst.grupo13.matacuas.dao.QuejaDAO;
import isst.grupo13.matacuas.dao.QuejaDAOImpl;
import isst.grupo13.matacuas.model.Queja;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;



@SuppressWarnings("serial")
public class VerQuejaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		//Queja queja =  req.getSession().getAttribute("queja");
		//Queja queja1 = (Queja) req.getAttribute("queja");
		//resp.getWriter().println(queja);
		//resp.getWriter().println(queja1);
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		Queja queja = dao.readQuejaId(id);
		/*BlobKey blobKey = new BlobKey( queja.getImagen());
		//BlobstoreInputStream is =new BlobstoreInputStream(blobKey);
		BlobstoreService blobStore = BlobstoreServiceFactory.getBlobstoreService();
		//blobStore= BlobstoreServiceFactory.getBlobstoreService();
		blobStore.serve(blobKey, resp);*/
		//BlobKey blobKey = new BlobKey(queja.getImagen());
		//blobstoreService.serve(blobKey, resp);
		//blobstoreService.serve(blobKey, resp);
		req.setAttribute("quejaAVer", queja);
		RequestDispatcher view = req.getRequestDispatcher("Queja.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
}