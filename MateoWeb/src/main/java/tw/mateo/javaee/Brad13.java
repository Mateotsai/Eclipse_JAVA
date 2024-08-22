package tw.mateo.javaee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad13")
public class Brad13 extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Brad14");
		
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print("Hello, I am Brad13");
		
		dispatcher.forward(request, response);
		response.getWriter().print("after");
	}


}
