package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	/*
	 * insert order to data base 
	 * 
	 * return order_id
	 * */
	public int insertOrders(String email, String address, String discount) {
		int orderId = 0;
		String query = "insert into Orders (user_mail, order_status, order_date, order_discount_code, order_address )\r\n"
				+ "values(\r\n"
				+ "	?,0,CURDATE(),?,?\r\n"
				+ ");";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query, new String[] {"order_id"});
			ps.setString(1, email);
			ps.setString(2, address);
			ps.setString(3, discount);
			orderId = ps.executeUpdate();
			if(orderId == 0) {
				throw new SQLException("create order failed");
			}else {
				java.sql.ResultSet generateKey = ps.getGeneratedKeys();
				if(generateKey.next()) {
					orderId = generateKey.getInt(1);
				}
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return orderId;
	}

	public void insertOrdersDetail(int orderId, int productId, double amountProduct, double priceProduct ) {
		String query = "insert into Orders_detail values (?, ?, ?, ?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderId);
			ps.setInt(2, productId);
			ps.setDouble(3, amountProduct);
			ps.setDouble(4, priceProduct);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Orders> getOrdersByEmail(String email){
		List<Orders> orders= new ArrayList<>();
		String query ="select * from Orders where user_mail = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				orders.add(new Orders(rs.getInt(2), 0, rs.getInt(3), rs.getDate(4), rs.getString(6), "", null, rs.getString(1), null, rs.getString(5)));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return orders;
	}
	
	public List<Product> getProductByOrderID(int orderId){
		List<Product> product = new ArrayList<>();
		String query ="select * from Orders_detail where order_id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			int index=0;
			while (rs.next()) {
				product.add(new getProductDao().getProductByID(rs.getInt(2)));
				product.get(index).setNumber((int)(rs.getDouble(3)/rs.getDouble(4)));
				index++;
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return product;
		
	}
}
