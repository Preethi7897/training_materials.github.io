package org.cts.services;

import java.util.List;

import org.cts.bean.Emp;

public interface EmpService {
	public boolean register(Emp e);
	public List<Emp> viewDetails();
}
