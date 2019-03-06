package org.cts.claims.model;

public class ClaimsInfo {

	int id;
	String cause;
	String policev;
	String firedpt;
	String steps;
	String details;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getPolicev() {
		return policev;
	}
	public void setPolicev(String policev) {
		this.policev = policev;
	}
	public String getFiredpt() {
		return firedpt;
	}
	public void setFiredpt(String firedpt) {
		this.firedpt = firedpt;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ClaimsInfo(int id, String cause, String policev, String firedpt,
			String steps, String details) {
		super();
		this.id = id;
		this.cause = cause;
		this.policev = policev;
		this.firedpt = firedpt;
		this.steps = steps;
		this.details = details;
	}
	
	
	
}
