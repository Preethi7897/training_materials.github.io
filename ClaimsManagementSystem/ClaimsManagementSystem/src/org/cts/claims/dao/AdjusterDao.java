package org.cts.claims.dao;

import java.util.List;

import org.cts.claims.model.*;

public interface AdjusterDao {
	
	String insertAdjuster( Adjuster a);
	Adjuster getAdjuster (int aid);
	List<Adjuster> getAdjusters();
	String deleteAdjuster(int aid);
	List<Adjuster> search(String name);

}