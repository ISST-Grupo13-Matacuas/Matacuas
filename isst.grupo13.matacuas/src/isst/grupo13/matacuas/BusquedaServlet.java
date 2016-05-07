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
public class BusquedaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String usuario = (String) req.getSession().getAttribute("user");
		String termino = req.getParameter("busqueda");
		req.setAttribute("termino", termino);
		int tipo = Integer.parseInt(req.getParameter("tipobusq"));		

			QuejaDAO dao = QuejaDAOImpl.getInstance();
			List <Queja> quejas = new ArrayList();
			//System.out.println(tipo + termino + usuario);
			switch (tipo){
			
			case 0:
				quejas = dao.read();
				break;
				
			case 1:
				List<Queja> quejasM = dao.readMatricula(termino);
				List<Queja> quejasD = dao.readDescripcion(termino);
				List<Queja> quejasL = dao.readLugar(termino);
				if(!quejasL.isEmpty())
				quejas.addAll(quejasL);
				if(!quejasD.isEmpty())
				quejas.addAll(quejasD);
				if(!quejasM.isEmpty())
				quejas.addAll(quejasM);
				break;
				
			case 2:
				quejas = dao.readMatricula(termino);
				break;
				
			case 3:
				quejas = dao.readDescripcion(termino);
				break;
				
			case 4:
				quejas = dao.readLugar(termino);
				break;
				
			case 5:
				quejas = dao.readTipo(1);
				break;
			
			case 6:
				quejas = dao.readTipo(2);
				
			default:
				break;
			
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
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		String usuario = (String) req.getSession().getAttribute("user");
		String termino = req.getParameter("busqueda");
		int tipo = Integer.parseInt(req.getParameter("tipobusq"));		

			QuejaDAO dao = QuejaDAOImpl.getInstance();
			List <Queja> quejas = new ArrayList();
			
			switch (tipo){
			
			case 0:
				quejas = dao.read();
				break;
				
			case 1:
				List<Queja> quejasM = dao.readMatricula(termino);
				List<Queja> quejasD = dao.readDescripcion(termino);
				List<Queja> quejasL = dao.readLugar(termino);
				if(!quejasL.isEmpty())
				quejas.addAll(quejasL);
				if(!quejasD.isEmpty())
				quejas.addAll(quejasD);
				if(!quejasM.isEmpty())
				quejas.addAll(quejasM);
				break;
				
			case 2:
				quejas = dao.readMatricula(termino);
				break;
				
			case 3:
				quejas = dao.readDescripcion(termino);
				break;
				
			case 4:
				quejas = dao.readLugar(termino);
				break;
				
			case 5:
				quejas = dao.readTipo(1);
				break;
			
			case 6:
				quejas = dao.readTipo(2);
				
			default:
				break;
			
			}
			
			req.getSession().setAttribute("quejas", new ArrayList<Queja>(quejas));
			
			resp.sendRedirect("/matacuas");
		}
	
}