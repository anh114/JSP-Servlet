package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Cart;
import model.Product;



@WebServlet("/add-to-cart")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public AddToCartController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		try {
			
			String action = request.getParameter("action");
			String idd = request.getParameter("id");
			if(action.equalsIgnoreCase("add")) {
				if (session.getAttribute("cart") == null) {
					session.setAttribute("cart", new Cart());
				}
			
				Product p = new ListProductDAO().getProduct(idd);
				Cart c = (Cart) session.getAttribute("cart");
				Product proInCart = new Product(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getSrc(), p.getType(), p.getBrand(), 1);
				
				c.add(proInCart);
				
			} else if (action.equalsIgnoreCase("delete")) {
				Cart c = (Cart) session.getAttribute("cart");
				int id = Integer.parseInt(idd);
				c.remove(id);
			}
		
			request.getRequestDispatcher("cart.jsp").forward(request, response);
				

		} catch (Exception ex) {
			response.getWriter().println(ex);
		}
	}

}
