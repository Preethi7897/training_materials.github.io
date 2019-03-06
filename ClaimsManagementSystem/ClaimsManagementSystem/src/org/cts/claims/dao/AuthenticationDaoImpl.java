package org.cts.claims.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.cts.claims.model.*;
import org.cts.claims.util.DBConstants;
import org.cts.claims.util.DBUtil;

public class AuthenticationDaoImpl implements Authentication_Dao {
    
	Connection connection = null;
	
	@Override
	public String insertUser(Authentication authentication) {
		
		String message = null;
		try {
		connection = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
		PreparedStatement preparedStatement = connection.prepareStatement("insert into users values(?,?,?)");
		preparedStatement.setString(1, authentication.getUname());
		preparedStatement.setString(2,authentication.getPwd());
		preparedStatement.setString(3, authentication.getRole());
		
		int update = preparedStatement.executeUpdate();
		if(update > 0)
			message = "sucess";
			else
				message = "not sucess";
				
		 connection.close();		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public List<Authentication> getUsers() {
		List<Authentication> authList = new ArrayList<>();
		try 
		{
			connection = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from authentication");
			while(resultSet.next())
			{
				authList.add(new Authentication(resultSet.getString(1),
						resultSet.getString(1),
						resultSet.getString(1)));
			}
			connection.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return authList;
		
	}

	@Override
	public String deleteUser(int uid) {
		  String message = null;
			
		  try {
			    connection = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);
				PreparedStatement preparedStatement = connection.prepareStatement("delete form authentication where id = ?");
				preparedStatement.setInt(1, uid);
				int flag  = preparedStatement.executeUpdate();
				if(flag > 0)
					message = "sucess";
				else
					message = "not sucess";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return message;	
	}

	@Override
	public List<Authentication> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
