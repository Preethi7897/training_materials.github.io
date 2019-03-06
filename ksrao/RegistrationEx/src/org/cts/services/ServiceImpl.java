package org.cts.services;

import java.util.List;

import org.cts.bean.Emp;
import org.cts.dao.EmpDao;
import org.cts.dao.EmpDaoImpl;

public class ServiceImpl implements EmpService {
	EmpDao dao=new EmpDaoImpl();
	
	@Override
	public boolean register(Emp e) {
		boolean res=dao.insert(e);
		return res;
	}

	@Override
	public List<Emp> viewDetails() {
		List<Emp> emps=dao.getEmployees();
		return emps;
	}

}
