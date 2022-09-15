package context;

import java.sql.*;

public class DBContext {
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://remotemysql.com:3306/";
	private String dbName = "0r9eJFc8Yt";
	private String user = "0r9eJFc8Yt";
	private String pass = "iPM1U8eKTe";
	
	public Connection getConnection() {
		Connection conn = null;
		String url = dbUrl+dbName;
		try {
			// load driver
			Class.forName(dbDriver);
			// create connection
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("loi load driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("loi tao ket noi");
			e.printStackTrace();
		}
		return conn;
	}
}
