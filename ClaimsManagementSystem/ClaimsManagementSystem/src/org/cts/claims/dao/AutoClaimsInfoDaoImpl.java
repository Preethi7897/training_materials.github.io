package org.cts.claims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.cts.claims.model.*;
import org.cts.claims.util.DBConstants;
import org.cts.claims.util.DBUtil;

public class AutoClaimsInfoDaoImpl implements AutoClaimsInfoDao{
	Connection con=null;
	@Override
	public String insertAutoClaimsInfo(AutoClaimsInfo aci) {
		String m=null;
		try{
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			PreparedStatement pst=con.prepareStatement("insert into autoclaimsinfo values(?,?,?,?,?,?,?,?,?)");
			
			pst.setInt(1,aci.getId());
			pst.setString(2,aci.getDlicense());
			pst.setString(3,aci.getVlicense());
			pst.setString(4,aci.getAmodel());
			pst.setInt(5,aci.getYear());
			pst.setString(6,aci.getAccident_date());
			pst.setString(7,aci.getAccident_place());
			pst.setString(8,aci.getDetails());
			pst.setString(9,aci.getPolicev());
			
			int r=pst.executeUpdate();

			if(r>0)

				m="success";

			else

				m="not success";

			con.close();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public AutoClaimsInfo getAutoClaimsInfo(int pid) {
		AutoClaimsInfo aci=null;
		try {

			  con = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);

				PreparedStatement preparedStatement = con.prepareStatement("select * from autoclaimsinfo where id = ?");
				preparedStatement.setInt(1, pid);
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();

				aci = new AutoClaimsInfo(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7), resultSet.getString(8),resultSet.getString(9));
				con.close();  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return aci;
	}
	
	@Override
	public List<AutoClaimsInfo> getAutoClaimsInfo() {
		List<AutoClaimsInfo> aciList = new ArrayList<>();

		try {

		  con = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);

			PreparedStatement preparedStatement = con.prepareStatement("select * from autoclaimsinfo");

			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){

				aciList.add(new AutoClaimsInfo(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7), resultSet.getString(8),resultSet.getString(9)));

				}

				con.close();
		}
		 catch (Exception e) {

			 e.printStackTrace();

		 }
		return aciList;
		}
	
	@Override
	public List<AutoClaimsInfo> search(String name) {
		return null;
	}

}
