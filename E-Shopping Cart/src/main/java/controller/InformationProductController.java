package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

public class InformationProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public InformationProductController() {
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
			String id = request.getParameter("id");
			ListProductDAO dao = new ListProductDAO();
			Product p = dao.getProduct(id);
			//set product by id data to jsp 
			request.setAttribute("product", p);
			request.getRequestDispatcher("infoProduct.jsp").forward(request, response);
		} catch (Exception e) {
			response.getWriter().println(e);
		}
	}
}
