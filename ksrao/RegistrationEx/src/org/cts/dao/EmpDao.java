package org.cts.dao;

import java.util.List;

import org.cts.bean.Emp;

public interface EmpDao {
	public boolean insert(Emp e);
	public List<Emp> getEmployees();
}
