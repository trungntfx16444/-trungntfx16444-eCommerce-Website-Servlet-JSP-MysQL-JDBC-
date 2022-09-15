package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdersDao;
import dao.getProductDao;
import model.Account;
import model.Cart;
import model.Orders;
import model.Product;

public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddToCartController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if (action.equals("add")) {

			addToCart(request, response);
		} else if (action.equals("del")) {
			delFromCart(request, response);
		} else if (action.equals("increase")) {
			increaseCart(request, response);
		} else if (action.equals("reduce")) {
			reduceCart(request, response);
		}
	}

	private void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("acc");
		if (acc != null) {
			// get id
			int id = Integer.parseInt(request.getParameter("id"));
			// get product by id
			Product p = new getProductDao().getProductByID(id);
			if (session.getAttribute("cart") == null) {
				Cart cart = new Cart();
				cart.add(p);
				session.setAttribute("cart", cart);
			} else {
				Cart cart = (Cart) session.getAttribute("cart");
				cart.add(p);
				session.setAttribute("cart", cart);
			}
			response.sendRedirect("cart.jsp");

		}else {
			response.sendRedirect("register.jsp");
		}

	}

	private void delFromCart(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// get id
		int id = Integer.parseInt(request.getParameter("id"));
		// remove product by id
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.remove(id);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart.jsp");
	}

	private void increaseCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.increaseProduct(id);
		response.sendRedirect("cart.jsp");
	}

	private void reduceCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.reduceProduct(id);
		if (cart.getProductById(id).getNumber() != 0) {
			response.sendRedirect("cart.jsp");
		} else {
			delFromCart(request, response);
		}

	}
}
