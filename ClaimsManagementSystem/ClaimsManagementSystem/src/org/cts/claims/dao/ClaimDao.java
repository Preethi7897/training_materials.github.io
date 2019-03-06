package org.cts.claims.dao;

import java.util.List;

import org.cts.claims.model.*;

public interface  ClaimDao {
  
     	String insertClaim( Claim a);
		Claim getClaim (int pid);
		List<Claim> getClaims();
		List<Claim> search(String name);

	}
