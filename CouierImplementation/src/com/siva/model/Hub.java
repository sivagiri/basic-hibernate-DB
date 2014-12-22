package com.siva.model;

public class Hub {
	
	private int hub_id;
	private String state_id ;
	private String hub_name;
	public int getHub_id() {
		return hub_id;
	}
	public void setHub_id(int hub_id) {
		this.hub_id = hub_id;
	}
	public String getState_id() {
		return state_id;
	}
	public void setState_id(String state_id) {
		this.state_id = state_id;
	}
	public String getHub_name() {
		return hub_name;
	}
	public void setHub_name(String hub_name) {
		this.hub_name = hub_name;
	}
	@Override
	public String toString() {
		return "Hub [hub_id=" + hub_id + ", state_id=" + state_id
				+ ", hub_name=" + hub_name + "]";
	}
	
	

}
