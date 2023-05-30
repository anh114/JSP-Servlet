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

/**
 * Servlet implementation class ListController
 */
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
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
			//load all data from database
			List<Product> ls = new ListProductDAO().getAllProduct();
			
			//Phan page
			int page, numberPerPage = 6;
			int size = ls.size();
			int totalPage = (size % numberPerPage == 0 ? size/numberPerPage : (size/numberPerPage)+1);
			String xpage = request.getParameter("page");
			if(xpage==null) {
				page = 1;
			} else {
				page = Integer.parseInt(xpage);
				
			}
			int start, end;
			start = (page - 1) * numberPerPage;
			end = Math.min(page*numberPerPage, size);
			//list đã được phân 
			List<Product> list = new ListProductDAO().getListByPage(ls, start, end);
			//set data to body.jsp
			request.setAttribute("products", list);
			request.setAttribute("page", page);
			request.setAttribute("numberPage", totalPage);
			request.getRequestDispatcher("./body.jsp").forward(request, response);
			
		} catch (Exception e) {
			Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
	}
}
