package com.siva.model;

public class State {
	
	private int state_id;
	private String state_name;
	private int country_id;
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	@Override
	public String toString() {
		return "State [state_id=" + state_id + ", state_name=" + state_name
				+ ", country_id=" + country_id + "]";
	}
	

}
