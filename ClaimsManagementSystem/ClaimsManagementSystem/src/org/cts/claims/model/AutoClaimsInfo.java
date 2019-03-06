package org.cts.claims.model;

public class AutoClaimsInfo {
 int id;
 String dlicense;
 String vlicense;
 String amodel;
 int year;
 String accident_date;
 String accident_place;
 String details;
 String policev;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDlicense() {
	return dlicense;
}
public void setDlicense(String dlicense) {
	this.dlicense = dlicense;
}
public String getVlicense() {
	return vlicense;
}
public void setVlicense(String vlicense) {
	this.vlicense = vlicense;
}
public String getAmodel() {
	return amodel;
}
public void setAmodel(String amodel) {
	this.amodel = amodel;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public String getAccident_date() {
	return accident_date;
}
public void setAccident_date(String accident_date) {
	this.accident_date = accident_date;
}
public String getAccident_place() {
	return accident_place;
}
public void setAccident_place(String accident_place) {
	this.accident_place = accident_place;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
public String getPolicev() {
	return policev;
}
public void setPolicev(String policev) {
	this.policev = policev;
}
public AutoClaimsInfo(int id, String dlicense, String vlicense, String amodel,
		int year, String accident_date, String accident_place, String details,
		String policev) {
	super();
	this.id = id;
	this.dlicense = dlicense;
	this.vlicense = vlicense;
	this.amodel = amodel;
	this.year = year;
	this.accident_date = accident_date;
	this.accident_place = accident_place;
	this.details = details;
	this.policev = policev;
}
 
}
