package org.cts.claims.dao;

import java.util.List;

import org.cts.claims.model.*;

public interface Authentication_Dao {
	
	String insertUser(Authentication a);
	//Authentication getAuthentication(int );
	List<Authentication> getUsers();
	String deleteUser(int uid);
	List<Authentication> search(String name);
	
	

}
