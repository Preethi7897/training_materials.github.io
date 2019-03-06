package org.cts.claims.model;

public class Adjuster {
	
	Integer id;
	String claim_type;
	String first_name;
	String last_name;
	Integer exp;
	
	
	public Adjuster(Integer id, String claim_type, String first_name, String last_name, Integer exp) {
		super();
		this.id = id;
		this.claim_type = claim_type;
		this.first_name = first_name;
		this.last_name = last_name;
		this.exp = exp;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getClaim_type() {
		return claim_type;
	}


	public void setClaim_type(String claim_type) {
		this.claim_type = claim_type;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public Integer getExp() {
		return exp;
	}


	public void setExp(Integer exp) {
		this.exp = exp;
	}
	
	

}