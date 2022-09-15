package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import model.Account;

public class AccountDao {
	private Connection conn = null;
	private PreparedStatement ps= null; 
	private ResultSet rs = null;
	public void inserAccount(Account acc) {
		String query = "insert into Account values(?,?,?,N?,N?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, acc.getUsr());
			ps.setString(2, acc.getPwd());
			ps.setInt(3, 1);
			ps.setString(4, acc.getName());
			ps.setString(5, acc.getAddress());
			ps.setString(6, acc.getPhone());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public Account getAccountByUser(String user) {
		String query= "select * from Account where user_mail = ?";
		Account acc = null;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while(rs.next()) {
				acc = new Account(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), 0);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return acc;
	}
}
