package isst.grupo13.matacuas;

import isst.grupo13.matacuas.dao.QuejaDAO;
import isst.grupo13.matacuas.dao.QuejaDAOImpl;
import isst.grupo13.matacuas.model.Queja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import com.google.appengine.api.datastore.Text;



@SuppressWarnings("serial")
public class NuevaQuejaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		
		String tipo = req.getParameter("tipo");
		//req.getSession().setAttribute("tipoQueja", tipo);
		req.setAttribute("tipoQueja", tipo);
		
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
		
		
		String usuario = (String) req.getSession().getAttribute("user");
		String lugar = req.getParameter("lugar");
		String matricula = req.getParameter("matricula");
		String descripcion = req.getParameter("descripcion");
		//Text imagen = null;
		//imagen = new Text(req.getParameter("imagenurl"));
		//System.out.println(imagen.getValue());
		
		/*if(imagen.toString()== ""){
			System.out.println("imagen nula");
			imagen = new Text("/images/"+ ((int) java.lang.Math.ceil(java.lang.Math.random() * 5)) + ".jpg");
		}*/
		//System.out.println(imagen);
		//if (req.getParameter("latitud") == null || req.getParameter("latitud") == ""){
		
		double lat = 0.0;
		double lng = 0.0;
		if (req.getParameter("latitud") != null && req.getParameter("latitud") != "" && req.getParameter("longitud")!= null && req.getParameter("longitud") != ""){
			lat =  Double.parseDouble(req.getParameter("latitud"));
			lng =Double.parseDouble(req.getParameter("longitud"));
		}
		
		
		
		
		
		int tipo = Integer.parseInt(req.getParameter("tipo"));
		Map<String, List<BlobKey>> blobs = BlobstoreServiceFactory.getBlobstoreService().getUploads(req);
		List<BlobKey> blobKeys = blobs.get("imagen");
		System.out.println(blobs.get("imagen"));
		String imagen = "";
		if ( blobKeys == null || blobKeys.isEmpty() || blobKeys .get(0) == null ) {
			imagen = "";
		}
		else{
			imagen = blobKeys.get(0).getKeyString();
			System.out.println(imagen);
		}
		
		if(lugar!= null && matricula!= null && descripcion != null && usuario!= "" ){
			QuejaDAO dao = QuejaDAOImpl.getInstance();
			Queja queja = dao.create(usuario, matricula, lugar, descripcion, lat, lng, imagen, 1,tipo);
			List<Queja> quejas = dao.read();
			
			req.getSession().setAttribute("quejas", new ArrayList<Queja>(quejas));
			/*
			RequestDispatcher view = req.getRequestDispatcher("SingleApp.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//Queja queja = dao.create()
			resp.sendRedirect("/matacuas");
		}
	}
}