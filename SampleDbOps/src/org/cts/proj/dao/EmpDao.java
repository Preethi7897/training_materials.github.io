package org.cts.proj.dao;

import java.util.List;

import org.cts.proj.beans.Emp;

public interface EmpDao {
	public boolean insert(Emp e);
	public boolean delete(int eno);
	public boolean update(int eno,String newName,String address);
	public List<Emp> getEmplyees();
	public Emp getEmployee(int eno);
	

}
