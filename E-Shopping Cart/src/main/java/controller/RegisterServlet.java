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

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
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

		// REGISTER
		if (action.equalsIgnoreCase("register")) {
			// collect data from a login forms
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			String repeatPassword = request.getParameter("repeatpassword");

			request.setAttribute("user", user);
			request.setAttribute("password", password);
			request.setAttribute("repeatpassword", repeatPassword);

			if (!password.equals(repeatPassword)) {
				// Passwords don't match.
				session.setAttribute("error", "Passwords do not match.");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}

			try {
				con = db.getConnection();
				Account acc = new Account(con);

				if (!acc.exists(user) && acc.valid(user, password)) {
					// We create create the Admin account to access index.jsp
					acc.createAdmmin(user, password, 1);
					acc.setRole(1);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				} else if (acc.exists(user)) {
					session.setAttribute("error", "An account with this email address already exists, please Login");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				} else if (!acc.valid(user, password)) {
					session.setAttribute("error", "Email or password is not valid");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Customer Register
		} else if (action.equalsIgnoreCase("CustomerReg")) {
			// collect data from a login Customer forms
			String userMail = request.getParameter("userMail");
			String password = request.getParameter("password");
			String repeatPassword = request.getParameter("repeatpassword");
			String userName = request.getParameter("userName");
			String userAddress = request.getParameter("userAddress");
			String userPhone = request.getParameter("userPhone");

			request.setAttribute("userMail", userMail);
			request.setAttribute("password", password);
			request.setAttribute("repeatpassword", repeatPassword);
			request.setAttribute("userName", userName);
			request.setAttribute("userAddress", userAddress);
			request.setAttribute("userPhone", userPhone);

			if (!password.equals(repeatPassword)) {
				// Passwords don't match.
				session.setAttribute("error", "Passwords do not match.");
				request.getRequestDispatcher("/cusreg.jsp").forward(request, response);
			}

			try {
				con = db.getConnection();
				Account acc = new Account(con);

				if (!acc.exists(userMail) && acc.valid(userMail, password)) {
					// We create create the Admin account to access index.jsp
					acc.createCustomer(userMail, password,2, userName, userAddress, userPhone);
					acc.setRole(2);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				} else if (acc.exists(userMail)) {
					session.setAttribute("error", "An account with this email address already exists, please Login");
					request.getRequestDispatcher("/cusreg.jsp").forward(request, response);
				} else if (!acc.valid(userMail, password)) {
					session.setAttribute("error", "Email or password is not valid");
					request.getRequestDispatcher("/cusreg.jsp").forward(request, response);
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
