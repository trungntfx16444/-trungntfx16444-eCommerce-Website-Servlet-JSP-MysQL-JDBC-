package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Cart {
	private List<Product> items;
	
	public Cart() {
		items = new ArrayList<>();
	}
	
	// add new product to cart
	public void add(Product p) {
		for (Product px: items) {
			if(p.getId() == px.getId()) {
				px.setNumber(px.getNumber()+1);
				return;
			}
		}
		items.add(p);
	}
	
	// remove a product from cart
	public void remove(int id) {
		for(Product px : items) {
			if(px.getId() == id) {
				items.remove(px);
				return;
			}
		}
	}
	
	// return total amont to cart
	public double getAmount() {
		double sum = 0;
		for(Product px : items) {
			sum+=px.getPrice() * px.getNumber();
		}
		return sum;
	}
	
	// return list of product in cart
	public List<Product> getItems(){
		return items;
	}
	
	// count number item in cart
	public int countItems() {
		int sum = 0;
		for (Product product : items) {
			sum+= product.getNumber();
		}
		return sum;
	}
	
	// incease number cart
	public void increaseProduct(int id) {
		for(Product p : items) {
			if(p.getId() == id) {
				p.setNumber(p.getNumber()+1);
			}
		}
	}
	
	// reduce number cart
	public void reduceProduct(int id) {
		for(Product p : items) {
			if(p.getId() == id) {
				p.setNumber(p.getNumber()-1);
			}
		}
	}

	// get product by id
	public Product getProductById(int id) {
		Product result = null;
		for(Product p : items) {
			if(p.getId() == id) {
				result = p;
			}
		}
		return result;
	}
	
}
