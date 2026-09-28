package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	public static Connection getDBConnection() {

		Connection con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/servlet_db";
			String user = "root";
			String password = "root";

			con = DriverManager.getConnection(url,user,password);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return con;
	}

}
