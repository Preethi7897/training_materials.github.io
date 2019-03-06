package org.cts.claims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.cts.claims.model.*;
import org.cts.claims.util.DBConstants;
import org.cts.claims.util.DBUtil;



public class AdjusterDaoImpl implements AdjusterDao {
    
	Connection connection  = null;
	
	@Override
	public String insertAdjuster(Adjuster a) {
		
		String message = null;
		try {
			connection = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);
			PreparedStatement preparedStatement = connection.prepareStatement("insert into adjuster values(?,?,?,?,?)");
			preparedStatement.setInt(1, a.getId());
			preparedStatement.setString(2, a.getClaim_type());
			preparedStatement.setString(3,a.getFirst_name());
			preparedStatement.setString(4, a.getLast_name());
			preparedStatement.setInt(5, a.getExp());
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
 	public Adjuster getAdjuster(int aid) {
 		  Adjuster adjuster = null;
		  try {
			  connection = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);
				PreparedStatement preparedStatement = connection.prepareStatement("select * from adjuster where pid = ?");
				preparedStatement.setInt(1, aid);
				ResultSet resultSet  = preparedStatement.executeQuery();
				resultSet.next();
				adjuster = new Adjuster(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));
				connection.close();  
				
		  }
		  catch (Exception e) {
			  e.printStackTrace();
		  }
		// TODO Auto-generated method stub
		return adjuster;
	}

	@Override
	public List<Adjuster> getAdjusters() {
		// TODO Auto-generated method stub
		
		List<Adjuster> adjusterList  = new ArrayList<Adjuster>();
		  try {
			  connection = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);
				PreparedStatement preparedStatement = connection.prepareStatement("select * from adjuster");
				ResultSet resultSet  = preparedStatement.executeQuery();
				while(resultSet.next())
				adjusterList.add(new Adjuster(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
				connection.close();  
				
		  }
		  catch (Exception e) {
			  e.printStackTrace();
		  }
		// TODO Auto-generated method stub
		return adjusterList;
	}

	@Override
	public String deleteAdjuster(int aid) {
		     
		  String message = null;
		
		  try {
			    connection = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);
				PreparedStatement preparedStatement = connection.prepareStatement("delete form adjuster where id = ?");
				preparedStatement.setInt(1, aid);
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
		
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<Adjuster> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
	