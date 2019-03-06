package org.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.cts.beans.User;
import org.cts.util.DBConstants;
import org.cts.util.DBUtil;


public class UserDaoImpl implements UserDao {

	@Override
	public boolean validateUser(User user) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean b=false;
		try {
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			pst=con.prepareStatement("select * from users where uname=? and pwd=?");
			pst.setString(1, user.getUname());
			pst.setString(2, user.getPwd());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
				b=true;
			else
				b=false;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	
	

}
