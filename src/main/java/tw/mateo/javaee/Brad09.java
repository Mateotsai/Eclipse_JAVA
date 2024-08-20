package tw.mateo.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Brad09")
@MultipartConfig(location = "C:\\Users\\User\\eclipse-workspace\\MateoWeb\\src\\main\\webapp\\upload")  //宣告我會處理，並指定儲存路徑
public class Brad09 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chatset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Part part = request.getPart("upload");
		System.out.println(part.getName());
		System.out.println(part.getSize());
		System.out.println(part.getSubmittedFileName());
		String filename = request.getRemoteAddr() + "_" + part.getSubmittedFileName();
		
		System.out.println(filename);
		
		if (part.getSize()>0) {
			part.write(part.getSubmittedFileName());
			out.print("Upload Success");
		}else {
			out.print("Upload Failure");
		}
		
	
	}

}
