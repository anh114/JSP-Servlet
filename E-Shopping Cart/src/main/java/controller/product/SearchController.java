package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;



public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SearchController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()) {
			String text = request.getParameter("s");
			ListProductDAO dao = new ListProductDAO();
			List<Product> list = dao.search(text);
			
			request.setAttribute("products", list);
			
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
		} catch (Exception e) {
			Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
	}
}
