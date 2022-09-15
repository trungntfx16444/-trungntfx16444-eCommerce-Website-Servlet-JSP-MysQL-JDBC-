package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdersDao;
import dao.getProductDao;
import model.Account;
import model.Orders;
import model.Product;
import model.ProductOrders;

public class HistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HistoryController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute("acc");
		OrdersDao dao = new OrdersDao();
		List<Orders> listOrder = dao.getOrdersByEmail(acc.getUsr());
		session.setAttribute("lo", listOrder);
		response.sendRedirect("history.jsp");
	}


}
