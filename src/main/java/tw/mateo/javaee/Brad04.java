package tw.mateo.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Brad04
 */
@WebServlet("/Brad04")
public class Brad04 extends HttpServlet {
	
    public Brad04() {
      System.out.println("Brad04()");
        
    }
    
//	@Override
//	public void init() throws ServletException {
//		System.out.println("init()");
//		super.init();
//		
//	}
//
//
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("init(ServletConfig)");
//		super.init(config);
//	}

    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   System.out.println("service(1) - 開始");
		    super.service(req, resp);
		    System.out.println("service(1) - 結束");
	}


	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	    System.out.println("service(2) - 開始");
	    super.service(req, res);
	    System.out.println("service(2) - 結束");
	
	}




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		PrintWriter out = response.getWriter();
		System.out.println("doget()");
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
