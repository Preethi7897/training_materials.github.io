package org.cts.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.cts.proj.beans.Emp;
import org.cts.proj.util.DBConstants;
import org.cts.proj.util.DBUtil;

public class EmpDaoImpl implements EmpDao {

	@Override
	public boolean insert(Emp e) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean b=false;
		try {
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			pst=con.prepareStatement("insert into emp(eno,name,address) values(?,?,?)");
			pst.setInt(1, e.getEno());
			pst.setString(2, e.getName());
			pst.setString(3, e.getAddress());
			int r=pst.executeUpdate();
			con.close();
			if(r>0)
				b=true;
			else
				b=false;
			con.close();
			
		} catch (Exception e2) {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		return b;
	}

	@Override
	public boolean delete(int eno) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean b=false;
		try {
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			pst=con.prepareStatement("delete from emp where eno=?");
			pst.setInt(1, eno);
			int r=pst.executeUpdate();
			if(r>0)
				b=true;
			else
				b=false;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean update(int eno,String newName, String address) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean b=false;
		try {
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			pst=con.prepareStatement("update emp set name=?,address=? where eno=?");
			pst.setString(1, newName);
			pst.setString(2, address);
			pst.setInt(3, eno);
			int r=pst.executeUpdate();
			if(r>0)
				b=true;
			else
				b=false;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Emp> getEmplyees() {
		List<Emp> emps=new ArrayList<>();
		Connection con=null;
		Statement st=null;
		try {
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from emp");
			while(rs.next())
			{
				emps.add(new Emp(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emps;
	}

	@Override
	public Emp getEmployee(int eno) {
		
		Connection con=null;
		PreparedStatement st=null;
		Emp e=null;
		try {
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			st=con.prepareStatement("select * from emp where eno=?");
			ResultSet rs=st.executeQuery();
			rs.next();
			
			e=new Emp(rs.getInt(1), rs.getString(2), rs.getString(3));
			con.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return e;
	}

}
