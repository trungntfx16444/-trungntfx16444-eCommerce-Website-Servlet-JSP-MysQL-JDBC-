package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.compiler.NewlineReductionServletWriter;

import context.DBContext;
import model.Product;

public class getProductDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/*
	 * get numbers product for 1 page
	 * 
	 * return list
	 */
	public List<Product> getPageProduct(int index) {
		List<Product> list = new ArrayList<>();
		int limitItem = 6;
		// query
		String query = "select * from Products limit ?, ?";
		try {
			conn = new DBContext().getConnection();// create connect mysql
			ps = conn.prepareStatement(query);// query
			ps.setInt(1, (index - 1) * limitItem);
			ps.setInt(2, limitItem);
			rs = ps.executeQuery();// create table result after query
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7), 1));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	/*
	 * count number in table product
	 * 
	 * return number product
	 */
	public int countNumberProduct() {
		String query = "select count(*) from Products";
		int numb = 0;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				numb = rs.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
		}

		return numb;
	}

	/*
	 * get product by id
	 * 
	 * return: product
	 */
	public Product getProductByID(int id) {
		String query = "select * from Products where Product_id = ?";
		Product product = null;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				product = new Product(id, rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), 1);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return product;
	}

	/*
	 * get list product by name
	 * 
	 * return list product
	 * */
	public List<Product> getProductsByName(String name){
		List<Product> list = new ArrayList<>();
		String query = "select * from Products where locate(?, product_name)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7), 1));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}
	
	public int countNumbSearch(String name) {
		String query = "select count(*) from(select * from Products where locate(?, product_name)>0) as temp";
		int number = 0;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				number = rs.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return number;
	}
	
	/*
	 * get number products for 1 page (search)
	 * 
	 * return list product
	 * */
	public List<Product> getProductSearchPage(int index, String name, int limitItem){
		List<Product> list = new ArrayList<>();
		String query = "select * from(select * from Products where locate(?, product_name)>0) as temp\r\n"
				+ "limit ?, ?;";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, (index-1)*limitItem);
			ps.setInt(3, limitItem);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7), 1));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
}
