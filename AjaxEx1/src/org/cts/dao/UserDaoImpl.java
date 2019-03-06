package org.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.jws.soap.SOAPBinding.Use;

import org.cts.beans.User;
import org.cts.util.DBConstants;
import org.cts.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User validateUser(int uid) {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		User user=null;
		try {
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			pst=con.prepareStatement("select * from users where uid=?");
			pst.setInt(1, uid);
			rs=pst.executeQuery();
			rs.next();
			user=new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
