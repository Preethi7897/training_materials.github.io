package org.cts.claims.dao;
import org.cts.claims.model.*;
import java.util.List;
public interface PolicyDao {
		
		String insertPolicy( Policy a);
		Policy getPolicy (int pid);
		List<Policy> getPolicies();
		List<Policy> search(String name);

	}