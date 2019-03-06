package org.cts.claims.dao;


	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

	//import adjustermodel.Adjuster;

import org.cts.claims.model.*;
import org.cts.claims.util.DBConstants;
import org.cts.claims.util.DBUtil;

	public class PolicyDaoImpl implements PolicyDao{
		Connection connection = null;
		@Override
		public String insertPolicy(Policy a) {
			String message = null;
			try {
				connection = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);
				PreparedStatement preparedStatement = connection.prepareStatement("insert into policy values(?,?,?,?,?)");
				preparedStatement.setInt(1, a.getId());
				preparedStatement.setString(2, a.getStart_date());
				preparedStatement.setDouble(3,a.getCoverage_amt());
				preparedStatement.setString(4, a.getPolicy_status());
				preparedStatement.setInt(5, a.getPolicy_term());
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
		public Policy getPolicy(int pid) {
			Policy policy = null;
			try {
				    connection = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);
					PreparedStatement preparedStatement = connection.prepareStatement("select * from policy where id = ?");
					preparedStatement.setInt(1, pid);
					ResultSet resultSet  = preparedStatement.executeQuery();
					resultSet.next();
					policy = new Policy(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4), resultSet.getInt(5));
					connection.close();  
					
			  }
			  catch (Exception e) {
				  e.printStackTrace();
			  }
			// TODO Auto-generated method stub
			return policy;
		}

		@Override
		public List<Policy> getPolicies() {
			List<Policy> policyList = new ArrayList<>();
			try {
			    connection = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);
				PreparedStatement preparedStatement = connection.prepareStatement("select * from policy");
				ResultSet resultSet  = preparedStatement.executeQuery();
				while(resultSet.next()){
					policyList.add(new Policy(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4), resultSet.getInt(5)));
				}
				connection.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return policyList;
		}

		@Override
		public List<Policy> search(String name) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
