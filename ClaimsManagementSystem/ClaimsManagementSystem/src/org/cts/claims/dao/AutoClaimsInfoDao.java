package org.cts.claims.dao;

import java.util.List;

import org.cts.claims.model.*;

public interface AutoClaimsInfoDao {
	String insertAutoClaimsInfo(AutoClaimsInfo a);
	AutoClaimsInfo getAutoClaimsInfo (int pid);
	List<AutoClaimsInfo> getAutoClaimsInfo();
	List<AutoClaimsInfo> search(String name);
	

}

