package org.cts.claims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.cts.claims.model.*;
import org.cts.claims.util.DBConstants;
import org.cts.claims.util.DBUtil;

public class ClaimDaoImpl implements ClaimDao {
     
	
	Connection connection = null;
	
	@Override
	public String insertClaim(Claim claim) {
		
		String msg=null;
		try
		{
			connection=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			PreparedStatement pst=connection.prepareStatement("insert into claims values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, claim.getId());
			pst.setInt(2, claim.getCustomer_id());
			pst.setInt(3, claim.getAdjuster_id());
			pst.setString(4, claim.getClaim_type());
			pst.setString(5, claim.getStatus());
			pst.setString(6, claim.getClaim_set_date());
			pst.setDouble(7, claim.getClaim_set_amt());
			pst.setDouble(8, claim.getSub_claim_amt());
			pst.setDouble(9, claim.getSalvage_rec_amt());
			pst.setInt(10, claim.getPolicy_id());
			pst.setInt(11, claim.getClaimsinfo_id());
			pst.setInt(12, claim.getAutoclaimsinfo_id());
			int r=pst.executeUpdate();
			if(r>0)
				msg="success";
			else
				msg="not success";
			
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;

	
	}

	

	@Override
	public List<Claim> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Claim getClaim(int cid) {
		Claim claim = null;
		try {
			    connection = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);
				PreparedStatement preparedStatement = connection.prepareStatement("select * from claims where id = ?");
				preparedStatement.setInt(1, cid);
				ResultSet resultSet  = preparedStatement.executeQuery();
				resultSet.next();
				claim = new Claim(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7), resultSet.getDouble(8),resultSet.getDouble(9), resultSet.getInt(10),resultSet.getInt(11),resultSet.getInt(12));
				connection.close();  
				
		  }
		  catch (Exception e) {
			  e.printStackTrace();
		  }
		// TODO Auto-generated method stub
		return claim;
	}



	@Override
	public List<Claim> getClaims() {
		List<Claim> claimsList = new ArrayList<>();
		try {
		    connection = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);
			PreparedStatement preparedStatement = connection.prepareStatement("select * from claims");
			ResultSet resultSet  = preparedStatement.executeQuery();
			while(resultSet.next()){
			claimsList.add(new Claim(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7), resultSet.getDouble(8),resultSet.getDouble(9), resultSet.getInt(10),resultSet.getInt(11),resultSet.getInt(12)));
			}
			connection.close(); 
			
			
	  }
	  catch (Exception e) {
		  e.printStackTrace();
	  }
	// TODO Auto-generated method stub
	return claimsList;
	}

}