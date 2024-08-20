package tw.mateo.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad11")
public class Brad11 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher =  request.getRequestDispatcher("Brad12");

		request.setAttribute("x", 10);
		request.setAttribute("name", "Peter");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<h1>Brad Big Company</h1>")
			.append("<hr />")
			.append("<div>Hello, World<div/>")
			.append("<hr />");
		
		dispatcher.include(request, response);
		out.append("<hr />");
		
		response.flushBuffer();
	}

}
