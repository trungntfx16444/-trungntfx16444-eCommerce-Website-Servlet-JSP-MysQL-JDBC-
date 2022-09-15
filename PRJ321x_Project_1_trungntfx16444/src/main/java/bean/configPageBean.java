package bean;

import java.util.List;

import context.DBContext;
import dao.getProductDao;
import model.Product;

public class configPageBean {
	
	/*
	 * get index page 
	 * return index page
	 * */
	public int getIndexPage(String index) {
		if(index == null)
			index = "1";
		return Integer.parseInt(index);
	}

	/*
	 * get end page 
	 * 
	 * return end page
	 * */
	public int getEndPage(int numbProduct, int LIMIT_ITEM) {
		int countProduct = new getProductDao().countNumberProduct();
		int endPage = countProduct/LIMIT_ITEM;
		if(countProduct % LIMIT_ITEM != 0)
			endPage++;
		return endPage;
	}

	/*
	 * get end page 
	 * 
	 * return end page
	 * */
	public int getEndPageSearch(int numbProduct, int LIMIT_ITEM, String searchValue) {
		int countProduct = new getProductDao().countNumbSearch(searchValue);
		int endPage = countProduct/LIMIT_ITEM;
		if(countProduct % LIMIT_ITEM != 0)
			endPage++;
		return endPage;
	}
	/*
	 * get list product 
	 * 
	 * return list product
	 * */
	public List<Product> getListProduct(int indexPage){
		List<Product> list = new getProductDao().getPageProduct(indexPage);
		return list;
	}
	
	/**
	 * get list product after search
	 * 
	 * return list product 
	 */
	public List<Product> getListProductSearch(int index, String searchValue, int LIMIT_ITEM){
			List<Product> list = new getProductDao().getProductSearchPage(index, searchValue, LIMIT_ITEM);
			return list;
	}
}
