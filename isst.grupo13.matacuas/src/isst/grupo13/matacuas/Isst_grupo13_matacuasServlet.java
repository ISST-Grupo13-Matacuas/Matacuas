package isst.grupo13.matacuas;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class Isst_grupo13_matacuasServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
    
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		String user = "";
		if(req.getUserPrincipal()!=null){
			user = req.getUserPrincipal().getName();
			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Logout";
			//resp.getWriter().println( "<p>Hola " + req.getUserPrincipal().getName() + "</p>");
			
		}
		//resp.getWriter().println( "<p>Pulsa <a href=\"" + url + "\">" + urlLinktext + "</a>.</p>" );
		
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);
		
		/*if (user == null || user == ""){
			RequestDispatcher view = req.getRequestDispatcher("Login.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		//else{
			RequestDispatcher view = req.getRequestDispatcher("SingleApp.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
		
		
		
	}
}
