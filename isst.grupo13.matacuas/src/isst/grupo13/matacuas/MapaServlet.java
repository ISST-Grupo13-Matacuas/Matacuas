package isst.grupo13.matacuas;

import isst.grupo13.matacuas.coordenadas.Coordenada;
import isst.grupo13.matacuas.dao.QuejaDAO;
import isst.grupo13.matacuas.dao.QuejaDAOImpl;
import isst.grupo13.matacuas.model.Queja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;



@SuppressWarnings("serial")
public class MapaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
			
		if (req.getSession().getAttribute("user")!=null){
		
		//List<Queja> quejas = (List<Queja>) req.getSession().getAttribute("quejas");
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		List<Queja> quejas = dao.read();
		List<Coordenada> coordenadas = new ArrayList<Coordenada>();
		
		for(Queja queja:quejas){
			Coordenada coord = new Coordenada(0.0,0.0);
			coord.setLat(queja.getLat());
			coord.setLng(queja.getLng());
			coordenadas.add(coord);
		}
		req.setAttribute("coordenadas", coordenadas);
		RequestDispatcher view = req.getRequestDispatcher("Mapa.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		else{
			resp.sendRedirect("/matacuas");
		}
	}
		
	
}