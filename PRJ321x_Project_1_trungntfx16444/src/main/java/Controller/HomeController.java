package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import dao.getProductDao;
import model.Account;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import bean.*;

public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int LIMIT_ITEM = 6;   
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		// get index 
		String index = request.getParameter("index");
		configPageBean bean = new configPageBean();
		int indexPage = bean.getIndexPage(index);
		// get EndPage 
		int endPage = bean.getEndPage(indexPage, LIMIT_ITEM);	
		request.setAttribute("endPage", endPage);
		// get list product
		List<Product> list  = bean.getListProduct(indexPage);
		request.setAttribute("listP", list);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}


}
