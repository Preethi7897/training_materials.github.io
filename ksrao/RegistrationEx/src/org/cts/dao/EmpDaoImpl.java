package org.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.cts.bean.Emp;
import org.cts.util.DBConstants;
import org.cts.util.DBUtil;

public class EmpDaoImpl implements EmpDao {

	@Override
	public boolean insert(Emp e) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean b=false;
		try {
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			pst=con.prepareStatement("insert into emp(eno,name,address,gender) values(?,?,?,?)");
			pst.setInt(1, e.getEno());
			pst.setString(2, e.getName());
			pst.setString(3, e.getAddress());
			pst.setString(4, e.getGender());
			int r=pst.executeUpdate();
			
			if(r>0)
				b=true;
			else
				b=false;
			con.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Emp> getEmployees() {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		List<Emp> emps=new ArrayList<Emp>();
		try {
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			st=con.createStatement();
			rs=st.executeQuery("select * from emp");
			while(rs.next())
			{
				emps.add(new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emps;
	}
	

}
