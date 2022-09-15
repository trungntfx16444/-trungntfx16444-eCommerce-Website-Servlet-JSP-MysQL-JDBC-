package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrdersDao;
import model.Product;

public class OrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		int orderID = Integer.parseInt(request.getParameter("id"));
		List<Product> listP = new OrdersDao().getProductByOrderID(orderID);
		request.setAttribute("listP", listP);
		request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
	}


}
