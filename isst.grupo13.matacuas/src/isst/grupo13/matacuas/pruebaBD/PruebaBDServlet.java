package isst.grupo13.matacuas.pruebaBD;
import isst.grupo13.matacuas.dao.QuejaDAO;
import isst.grupo13.matacuas.dao.QuejaDAOImpl;
import isst.grupo13.matacuas.model.Queja;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class PruebaBDServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.getWriter().println("<h1>Prueba de base de datos</h1>");
		QuejaDAO dao = QuejaDAOImpl.getInstance();
		List<Queja> quejas = dao.read();
		if (quejas.size() == 0){
			Queja queja1 =  dao.create("charlygs94@gmail.com", "7952HWT", "Calle Murillo", "Choque con otro vehiculo", 40.401450, -3.784832, "car.jpg", 1);
			Queja queja2 =  dao.create("charlygs94@gmail.com", "4675DVD", "Príncipe Pío", "Se ha saltado un semáforo", 40.421111, -3.720870, "car.jpg", 1);
		}
		
		//dao.delete(queja1);
		//dao.delete(queja2);
	
		
		resp.getWriter().println("Base entera:");
		resp.getWriter().println("<br>");
		//resp.getWriter().println(queja1);
		for(Queja queja:dao.read()){
			resp.getWriter().println(queja.getId() + " " + queja);
			resp.getWriter().println("<br>");
		}
		
		resp.getWriter().println("Usuario:");
		resp.getWriter().println("<br>");
		for(Queja queja:dao.readUsuario("charlygs94@gmail.com")){
			resp.getWriter().println(queja);
			resp.getWriter().println("<br>");
		}
		resp.getWriter().println("Matrícula:");
		resp.getWriter().println("<br>");
		for(Queja queja:dao.readMatricula("7952HWT")){
			resp.getWriter().println(queja);
			resp.getWriter().println("<br>");
		}
		resp.getWriter().println("Estado:");
		resp.getWriter().println("<br>");
		for(Queja queja:dao.readEstado(1)){
			resp.getWriter().println(queja);
			resp.getWriter().println("<br>");
		}
	}
}