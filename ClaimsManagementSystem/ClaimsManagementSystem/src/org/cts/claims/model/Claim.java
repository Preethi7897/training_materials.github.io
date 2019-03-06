package org.cts.claims.model;

public class Claim {
	
	   int id;
	   int customer_id;
	   int adjuster_id;
	   String claim_type;
	   String status;
	   String claim_set_date;
	   double claim_set_amt;
	   double sub_claim_amt;
	   double salvage_rec_amt;
	   int policy_id;
	   int claimsinfo_id;
	   int autoclaimsinfo_id;
	public int getClaimsinfo_id() {
		return claimsinfo_id;
	}
	public void setClaimsinfo_id(int claimsinfo_id) {
		this.claimsinfo_id = claimsinfo_id;
	}
	public int getAutoclaimsinfo_id() {
		return autoclaimsinfo_id;
	}
	public void setAutoclaimsinfo_id(int autoclaimsinfo_id) {
		this.autoclaimsinfo_id = autoclaimsinfo_id;
	}
	
	public Claim(int id, int customer_id, int adjuster_id, String claim_type,
			String status, String claim_set_date, double claim_set_amt,
			double sub_claim_amt, double salvage_rec_amt, int policy_id,
			int claimsinfo_id, int autoclaimsinfo_id) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.adjuster_id = adjuster_id;
		this.claim_type = claim_type;
		this.status = status;
		this.claim_set_date = claim_set_date;
		this.claim_set_amt = claim_set_amt;
		this.sub_claim_amt = sub_claim_amt;
		this.salvage_rec_amt = salvage_rec_amt;
		this.policy_id = policy_id;
		this.claimsinfo_id = claimsinfo_id;
		this.autoclaimsinfo_id = autoclaimsinfo_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getAdjuster_id() {
		return adjuster_id;
	}
	public void setAdjuster_id(int adjuster_id) {
		this.adjuster_id = adjuster_id;
	}
	public String getClaim_type() {
		return claim_type;
	}
	public void setClaim_type(String claim_type) {
		this.claim_type = claim_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getClaim_set_date() {
		return claim_set_date;
	}
	public void setClaim_set_date(String claim_set_date) {
		this.claim_set_date = claim_set_date;
	}
	public double getClaim_set_amt() {
		return claim_set_amt;
	}
	public void setClaim_set_amt(double claim_set_amt) {
		this.claim_set_amt = claim_set_amt;
	}
	public double getSub_claim_amt() {
		return sub_claim_amt;
	}
	public void setSub_claim_amt(double sub_claim_amt) {
		this.sub_claim_amt = sub_claim_amt;
	}
	public double getSalvage_rec_amt() {
		return salvage_rec_amt;
	}
	public void setSalvage_rec_amt(double salvage_rec_amt) {
		this.salvage_rec_amt = salvage_rec_amt;
	}
	public int getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}
	   
	   
	

}