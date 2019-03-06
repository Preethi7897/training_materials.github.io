package org.cts.claims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.cts.claims.util.DBConstants;
import org.cts.claims.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public String validateUser(String uname, String pwd) {
		Connection con = null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String role="";
		try {
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			pst=con.prepareStatement("select role from users where uname=? and pwd=?");
			pst.setString(1, uname);
			pst.setString(2, pwd);
			rs=pst.executeQuery();
			System.out.println("hello");
			if(rs.next())
			{
				role=role+rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

}
