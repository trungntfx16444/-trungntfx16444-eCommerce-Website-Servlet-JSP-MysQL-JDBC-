package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.configPageBean;
import dao.getProductDao;
import model.Product;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int LIMIT_ITEM = 6;

	public SearchController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String searchValue = request.getParameter("searchValue");
		int numbProduct = new getProductDao().countNumbSearch(searchValue);
		if (numbProduct != 0) {
			String indexPage = request.getParameter("index");
			configPageBean bean = new configPageBean();
			int index = bean.getIndexPage(indexPage);
			int endPage = bean.getEndPageSearch(numbProduct, LIMIT_ITEM, searchValue);
			List<Product> list = bean.getListProductSearch(index, searchValue, LIMIT_ITEM);

			// set Attribute
			request.setAttribute("endPage", endPage);
			request.setAttribute("listP", list);
			request.setAttribute("search", searchValue);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			request.setAttribute("mess", "Can't find Product");
			request.setAttribute("hidden", "d-none");
			request.setAttribute("padding", "pt-5 pb-5");
			request.setAttribute("search", searchValue);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
