package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import model.Product;


@WebServlet("/quantity-inc-dec")
public class QuantityProductInCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QuantityProductInCart() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter();) {
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			
			Cart carts = (Cart) request.getSession().getAttribute("cart");
			
			List<Product> cartList = carts.getItems();
			//An nut tang
			if(action.equalsIgnoreCase("inc")) {
				for(Product p : cartList) {
					if(p.getId() == id) {
						int quantity = p.getNumber();
						quantity++;
						p.setNumber(quantity);
						response.sendRedirect("cart.jsp");
					}
					
				}
			}
			//An nut giam
			if(action.equalsIgnoreCase("dec")) {
				for(Product p : cartList) {
					if(p.getId() == id) {
						int quantity = p.getNumber();
						if(quantity > 0) {
							quantity--;
							p.setNumber(quantity);
							
						} else {
							quantity = 0;
						}
						response.sendRedirect("cart.jsp");
					}
					
				}
			}
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
