package org.cts.claims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.cts.claims.model.*;
import org.cts.claims.util.DBConstants;
import org.cts.claims.util.DBUtil;

public class ClaimsInfoDaoImpl implements ClaimsInfoDao {

	Connection con = null;

	@Override
	public String insertClaimsInfo(ClaimsInfo cfi) {
		String msg=null;
		
		try{
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			PreparedStatement ps=con.prepareStatement("insert into claimsinfo values(?,?,?,?,?,?)");
			ps.setInt(1,cfi.getId());
			ps.setString(2,cfi.getCause());
			ps.setString(3,cfi.getPolicev());
			ps.setString(4,cfi.getFiredpt());
			ps.setString(5,cfi.getSteps());
			ps.setString(6,cfi.getDetails());
			
			int r=ps.executeUpdate();
			if(r>0)
				msg="success";
			else
				msg="not success";
			
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return msg;
	}

	@Override
	public ClaimsInfo getClaimsInfo(int ciid) {
		// TODO Auto-generated method stub
		ClaimsInfo ci=null;
		try{
			con= DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);
			PreparedStatement ps= con.prepareStatement("select * from claimsinfo where id = ?");
			ps.setInt(1,ciid);
			ResultSet rs=ps.executeQuery();
			ci=new ClaimsInfo(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5), 
					rs.getString(6));
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ci;
	}

	@Override
	public List<ClaimsInfo> getClaimsInfo() {
		// TODO Auto-generated method stub
		List<ClaimsInfo> ciList = new ArrayList<>();
		try{
			con = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,DBConstants.UNAME , DBConstants.PWD);
		PreparedStatement ps=con.prepareStatement("select * from claimsinfo");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			ciList.add(new ClaimsInfo(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5), 
					rs.getString(6)
					)
				);
		}
		con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ciList;
	}

	@Override
	public List<ClaimsInfo> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
