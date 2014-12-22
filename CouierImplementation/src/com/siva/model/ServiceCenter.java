package com.siva.model;

public class ServiceCenter {

private int sc_id;
private int hub_id;
private String sc_name;
public int getSc_id() {
	return sc_id;
}
public void setSc_id(int sc_id) {
	this.sc_id = sc_id;
}
public int getHub_id() {
	return hub_id;
}
public void setHub_id(int hub_id) {
	this.hub_id = hub_id;
}
public String getSc_name() {
	return sc_name;
}
public void setSc_name(String sc_name) {
	this.sc_name = sc_name;
}
@Override
public String toString() {
	return "ServiceCenter [sc_id=" + sc_id + ", hub_id=" + hub_id
			+ ", sc_name=" + sc_name + "]";
} 	 	






}
