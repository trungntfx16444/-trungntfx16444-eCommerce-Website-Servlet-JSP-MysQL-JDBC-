package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;
import model.Account;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		try {

			request.getSession(true).invalidate();
			// make sure that email is valid
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			// collect data from a login form
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			String remember = request.getParameter("remember");
			Account acc = new AccountDao().getAccountByUser(user);
			HttpSession session = request.getSession(true);
			if (acc != null) {
				if (!user.matches(regexMail) || !pass.matches(regex)) {
					session.setAttribute("error", "invalid syntax");
					response.sendRedirect("login.jsp");
				}

				// check user and pass
				if (user != null && acc.getUsr().equals(user) && acc.getPwd().equals(pass)) {
					// set session
					//session.setAttribute("user", user.substring(0, user.indexOf("@")));
					// create cookie
					Cookie userC = new Cookie("userCookie", acc.getUsr());
					Cookie rememberC = new Cookie("rememberCookie", remember);

					// set age cookie
					userC.setMaxAge(500);
					rememberC.setMaxAge(500);
					
					// add cookie
					response.addCookie(userC);
					response.addCookie(rememberC);
					if (acc.getRole() == 10) {
						//if admin user (go to admin page)
						response.sendRedirect("./admin/index.jsp");
					}else {
						// if client user (go to home page)
						session.setAttribute("acc", acc);
						response.sendRedirect("Home");
					}

				} else {
					session.setAttribute("error", "Wrong username or password");
					response.sendRedirect("login.jsp");
				}

			} else {
				session.setAttribute("error", "Account not exist");
				response.sendRedirect("login.jsp");
			}

		} catch (NullPointerException e) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (Exception e) {
			response.getWriter().println(e);
		}
	}

}
