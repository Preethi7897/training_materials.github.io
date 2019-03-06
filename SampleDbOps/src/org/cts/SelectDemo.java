package org.cts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","root");
			if(con!=null)
			{
				st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from emp");
				while(rs.next())
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			else
			{
				System.out.println("connection problem");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
