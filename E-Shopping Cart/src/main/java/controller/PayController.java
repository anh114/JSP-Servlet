package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import content.DBContext;
import dao.OrdersDAO;
import model.Account;
import model.Cart;
import model.Orders;


public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public PayController() {
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
		try (PrintWriter out = response.getWriter()) {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			Connection con = null;
			DBContext db = new DBContext();
			String userMail = (String) session.getAttribute("user");
		
			//if Customer is already login
		if(userMail != null) {
			/*Order: Orders(int orderId, float price, int status, Date orderDate, String address, String phoneNumber,
			List<ProductOrders> lp, String userMail, Date receivedDate)
			
			Orders(int status, String address, String phoneNumber, String userMail, Date receivedDate, String discount)
			ProductOrders(int orderId, int productId, int amountProduct, String nameProduct)
			
			*/
			con = db.getConnection();
			OrdersDAO dao = new OrdersDAO(con);
			
			Account acc = new Account(con);
			ArrayList<String> customer = acc.findCus(userMail);

			
			String userName = customer.get(0);
			String userAddress = customer.get(1);
			String userPhone = customer.get(2);
			
			session.setAttribute("cusName", userName);
			session.setAttribute("cusAddress", userAddress);
			session.setAttribute("cusPhone", userPhone);
			
			
			Orders d = new Orders(2, userAddress, userPhone, userMail, LocalDate.now(), "" );
			
			//Cart<Product>: int id, String name, float price, int number; getAmount(); size()
			Cart c = (Cart) session.getAttribute("cart");
			
			int orderId = dao.insertOrder(d, c);
			if(orderId > 0) {
				dao.insertOrderDetail(c, d, orderId);
			}
			
			
			if(request.getParameter("deleteCart").equals("ok")) {
				request.getRequestDispatcher("pay.jsp").forward(request, response);
				if(c != null) {
					c.deleteCart();
				
				}
			}
			
		}else {
			//Chua login 
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
