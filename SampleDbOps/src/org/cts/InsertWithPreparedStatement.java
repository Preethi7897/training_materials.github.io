package org.cts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertWithPreparedStatement {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pst=null;
		int eno;
		String name,address;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","root");
			if(con!=null)
			{
				pst=con.prepareStatement("insert into emp values(?,?,?)");
				System.out.println("enter the employee details");
				eno=Integer.parseInt(br.readLine());
				name=br.readLine();
				address=br.readLine();
				pst.setInt(1, eno);
				pst.setString(2, name);
				pst.setString(3, address);
				int r=pst.executeUpdate();
				if(r>0)
					System.out.println("successfully inserted");
				else
					System.out.println("not inserted");
				
			}
			else
			{
				System.out.println("connection problem");
			}
			con.close();
		} 
		catch (Exception e)
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}
