package isst.grupo13.matacuas;

import isst.grupo13.matacuas.dao.QuejaDAO;
import isst.grupo13.matacuas.dao.QuejaDAOImpl;
import isst.grupo13.matacuas.model.Queja;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

public class ConsultarAseguradoraServlet extends HttpServlet{
	
	public void doGet (HttpServletRequest req, HttpServletResponse resp)
		throws IOException {
		
		String matricula = req.getParameter("matricula");
		
		int numQuejas = 0;
		int numFelicitaciones = 0;
		int balance = 0;
		
		System.out.println("matricula:"+matricula);
		
		
		if(matricula != null && matricula != ""  ){
			
			QuejaDAO dao  = QuejaDAOImpl.getInstance();
			int tipo = 1;
			List<Queja> quejasMatricula = dao.readQuejaMatriculaTipo(matricula, tipo);
			System.out.println(quejasMatricula);
			tipo = 2;
			List<Queja> felicitacionesMatricula = dao.readQuejaMatriculaTipo(matricula, tipo);	
			System.out.println(felicitacionesMatricula);
			
			numQuejas = quejasMatricula.size();
			numFelicitaciones = felicitacionesMatricula.size();
			balance = numFelicitaciones - numQuejas;
		}
		
		req.setAttribute("numQuejas", numQuejas);
		req.setAttribute("numFelicitaciones", numFelicitaciones);
		req.setAttribute("balance", balance);
		req.setAttribute("matricula", matricula);
		
			RequestDispatcher view = req.getRequestDispatcher("ConsultaAseguradoras.jsp");
			
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
			}
		
	}

}
