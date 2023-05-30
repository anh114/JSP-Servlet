package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import content.DBContext;
import model.Account;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		request.getSession(true).invalidate();
		HttpSession session = request.getSession(true);
		String action = request.getParameter("action");

		if (action == null) {
			session.setAttribute("error", "action is null");
			request.getRequestDispatcher("body.jsp").forward(request, response);
			
		}
		Connection con = null;
		DBContext db = new DBContext();

		// LOGIN
		if (action.equalsIgnoreCase("dologin")) {
			// collect data from a login forms
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			String remember = request.getParameter("chkRemember");

			request.setAttribute("user", user);
			request.setAttribute("password", password);
			request.setAttribute("remember", remember);

			try {
				con = db.getConnection();
				
				Account acc = new Account(con);
				
					//Account is Admin
					if (acc.login(user, password) && acc.checkAdmin(user)) {
						session.setAttribute("user", user);
						Cookie c = new Cookie("userCook", user);
						if(remember != null) {
							c.setMaxAge(60*60*24);
						} else {
							c.setMaxAge(0);
						}
						response.addCookie(c);
						// login is valid, now redirect to index page of admin
						request.getRequestDispatcher("admin/index.jsp").forward(request, response);
				
						//Account is customer
				} else if(acc.login(user, password) && !acc.checkAdmin(user)) {
					
					session.setAttribute("user", user);
					Cookie c = new Cookie("userCook", user);
					if(remember != null) {
						c.setMaxAge(60*60*24);
					} else {
						c.setMaxAge(0);
					}
					response.addCookie(c);
					
					// login is valid, now redirect Pay page
					request.getRequestDispatcher("ListController").forward(request, response);
					
				} else {
					session.setAttribute("error", "wrong username or password");
					response.sendRedirect("login.jsp");
				}
	
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}

}
