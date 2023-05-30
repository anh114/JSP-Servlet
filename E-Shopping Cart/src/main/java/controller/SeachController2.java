package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

@WebServlet("/SearchController2")
public class SeachController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SeachController2() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		
		try {
			String text = request.getParameter("s");
			ListProductDAO dao = new ListProductDAO();
			
			//user search product on search bar
			List<Product> list = dao.search(text);
			
			request.setAttribute("products", list);
			
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} catch (Exception e) {
			response.getWriter().println(e);
		}
	}

}
