package com.siva.model;

public class HubAgent {
	
	private int hub_agent_id;
	private int hub_id;
	private String hub_agent_name;
	private String franchise_company_name;
	private String address;
	private String mobile_no   ;
	private String land_line_no;
	private String owner_name;
	private String owner_mobile;
	public int getHub_agent_id() {
		return hub_agent_id;
	}
	public void setHub_agent_id(int hub_agent_id) {
		this.hub_agent_id = hub_agent_id;
	}
	public int getHub_id() {
		return hub_id;
	}
	public void setHub_id(int hub_id) {
		this.hub_id = hub_id;
	}
	public String getHub_agent_name() {
		return hub_agent_name;
	}
	public void setHub_agent_name(String hub_agent_name) {
		this.hub_agent_name = hub_agent_name;
	}
	public String getFranchise_company_name() {
		return franchise_company_name;
	}
	public void setFranchise_company_name(String franchise_company_name) {
		this.franchise_company_name = franchise_company_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
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
		return "HubAgent [hub_agent_id=" + hub_agent_id + ", hub_id=" + hub_id
				+ ", hub_agent_name=" + hub_agent_name
				+ ", franchise_company_name=" + franchise_company_name
				+ ", address=" + address + ", mobile_no=" + mobile_no
				+ ", land_line_no=" + land_line_no + ", owner_name="
				+ owner_name + ", owner_mobile=" + owner_mobile + "]";
	}
	
	

}
