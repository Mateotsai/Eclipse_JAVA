package tw.mateo.javaee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Brad15")
public class Brad15 extends HttpServlet {
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//接收參數
		request.setCharacterEncoding("UTF-8");
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		

		//運算工作指派出去
		try {
			tw.mateo.apis.MyModel myModel = new tw.mateo.apis.MyModel(x,y);
			String result = myModel.plus();
			request.setAttribute("result", result);
			request.setAttribute("x", x);
			request.setAttribute("y", y);
//			request.setAttribute("view","view");
			
		} catch (Exception e) {
			request.setAttribute("result","");  //出現例外，結果就空給他
			request.setAttribute("x", x==null?"":x);
			request.setAttribute("y", y==null?"":y);
		}
		
		//呈現View
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Brad16");
		dispatcher.forward(request, response);
	}

	
}
