package context;

import java.sql.*;

public class DBContext {
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://sql6.freemysqlhosting.net:3306/";
	private String dbName = "sql6529007";
	private String user = "sql6529007";
	private String pass = "hbR7xlp53M";
	
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
