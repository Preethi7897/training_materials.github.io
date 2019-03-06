package org.cts.claims.dao;

import java.util.List;

import org.cts.claims.model.*;


public interface ClaimsInfoDao {

	String insertClaimsInfo( ClaimsInfo a);
	ClaimsInfo getClaimsInfo (int pid);
	List<ClaimsInfo> getClaimsInfo();
	List<ClaimsInfo> search(String name);
}
