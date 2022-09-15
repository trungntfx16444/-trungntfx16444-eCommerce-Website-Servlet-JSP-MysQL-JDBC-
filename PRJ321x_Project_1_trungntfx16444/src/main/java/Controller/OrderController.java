package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdersDao;
import model.Account;
import model.Cart;
import model.Orders;
import model.Product;

public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		String discound = request.getParameter("discound");
		Account acc = (Account)session.getAttribute("acc");
		// insert orders
		OrdersDao dao = new OrdersDao();
		int key = dao.insertOrders(acc.getUsr(), discound, acc.getAddress());

		// create orders
		Orders order = new Orders(
				key,// order id;
				cart.getAmount(),//amount price
				0,// order status
				null,// order date
				acc.getAddress(),//  order address 
				acc.getPhone(),// phone number
				cart.getItems(),// list product
				acc.getUsr(),// byer mail
				null, // receive date
				discound); // discoud code);

		// insert order_detail
		for(Product p: cart.getItems()) {
			dao.insertOrdersDetail(order.getOrderID(), p.getId(), (p.getNumber()*p.getPrice()), p.getPrice());
		}
		response.sendRedirect("History");
	}

}
