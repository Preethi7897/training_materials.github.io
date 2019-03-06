package org.cts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		int eno;
		String name,address;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","root");
			if(con!=null)
			{
				System.out.println("enter the employee details");
				eno=Integer.parseInt(br.readLine());
				name=br.readLine();
				address=br.readLine();
				st=con.createStatement();
				int r=st.executeUpdate("insert into emp values("+eno+",'"+name+"','"+address+"')");
				if(r>0)
					System.out.println("successfully inserted");
				else
					System.out.println("not inserted");
			}
			else
				System.out.println("not established");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
