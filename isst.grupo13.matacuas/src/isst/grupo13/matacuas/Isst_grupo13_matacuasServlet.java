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
		/*resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
		resp.getWriter().println("<head>");
		resp.getWriter().println("<meta charset=" + "utf-8" + ">"); 
		resp.getWriter().println("<meta http-equiv=" + "X-UA-Compatible" + " content=" + "IE=edge" + ">");
		resp.getWriter().println("")<meta name="viewport" content="width=device-width, initial-scale=1">
		resp.getWriter().println("")<meta name="description" content="">
		resp.getWriter().println("") <meta name="author" content="">
		resp.getWriter().println("")<title>Matacuás</title>
		resp.getWriter().println("") <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
		resp.getWriter().println("") <link rel="stylesheet" href="http://cdn.jsdelivr.net/animatecss/2.1.0/animate.min.css">
		resp.getWriter().println("")<link rel="stylesheet" href="stylesheet/basico.css">
		resp.getWriter().println("")<style>
		resp.getWriter().println("")</style>
		resp.getWriter().println("")<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		resp.getWriter().println("")<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    
    resp.getWriter().println("</head>")*/
		
    
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
		
		
		/*RequestDispatcher view = req.getRequestDispatcher("SingleApp.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
