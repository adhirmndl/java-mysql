package com.ivis.mysql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import com.mysql.cj.protocol.Resultset;

public class connection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost/test";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, "scot", "tiger");


		Calendar calendar = Calendar.getInstance();
		java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

		// the mysql insert statement
//		String query = "insert into `testtable` value('157904',\"Aditya Gupta\");";
		String query = "SELECT * FROM test.testtable;";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString(2));
			
		}
		// execute the preparedstatement
//		preparedStmt.execute();
		conn.close();
	}
}
