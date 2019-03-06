package org.cts.claims.model;


public class Policy {
	
	int id;
	String start_date;
	double coverage_amt;
	String policy_status;
	int policy_term;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public double getCoverage_amt() {
		return coverage_amt;
	}
	public void setCoverage_amt(double coverage_amt) {
		this.coverage_amt = coverage_amt;
	}
	public String getPolicy_status() {
		return policy_status;
	}
	public void setPolicy_status(String policy_status) {
		this.policy_status = policy_status;
	}
	public int getPolicy_term() {
		return policy_term;
	}
	public void setPolicy_term(int policy_term) {
		this.policy_term = policy_term;
	}
	public Policy(int id, String start_date, double coverage_amt, String policy_status, int policy_term) {
		super();
		this.id = id;
		this.start_date = start_date;
		this.coverage_amt = coverage_amt;
		this.policy_status = policy_status;
		this.policy_term = policy_term;
	}

}
