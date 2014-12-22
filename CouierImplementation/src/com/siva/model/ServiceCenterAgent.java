package com.siva.model;

public class ServiceCenterAgent {
	private int sc_agent_id ;
	private int sc_id;
	private String sc_agent_name;
	private String enterprise_name;
	private String mobile_no ;
	private String address;
	private String  land_line_no;
	private String owner_name;
	private String owner_mobile;
	public int getSc_agent_id() {
		return sc_agent_id;
	}
	public void setSc_agent_id(int sc_agent_id) {
		this.sc_agent_id = sc_agent_id;
	}
	public int getSc_id() {
		return sc_id;
	}
	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}
	public String getSc_agent_name() {
		return sc_agent_name;
	}
	public void setSc_agent_name(String sc_agent_name) {
		this.sc_agent_name = sc_agent_name;
	}
	public String getEnterprise_name() {
		return enterprise_name;
	}
	public void setEnterprise_name(String enterprise_name) {
		this.enterprise_name = enterprise_name;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLand_line_no() {
		return land_line_no;
	}
	public void setLand_line_no(String land_line_no) {
		this.land_line_no = land_line_no;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getOwner_mobile() {
		return owner_mobile;
	}
	public void setOwner_mobile(String owner_mobile) {
		this.owner_mobile = owner_mobile;
	}
	@Override
	public String toString() {
		return "ServiceCenterAgent [sc_agent_id=" + sc_agent_id + ", sc_id="
				+ sc_id + ", sc_agent_name=" + sc_agent_name
				+ ", enterprise_name=" + enterprise_name + ", mobile_no="
				+ mobile_no + ", address=" + address + ", land_line_no="
				+ land_line_no + ", owner_name=" + owner_name
				+ ", owner_mobile=" + owner_mobile + "]";
	}
	
	

}
