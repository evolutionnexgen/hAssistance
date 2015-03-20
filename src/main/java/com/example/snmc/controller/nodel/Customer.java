package com.example.snmc.controller.nodel;

public class Customer {
	String custId;
	String name;
	String mobile;

	public Customer(String custId, String name, String mobile) {
		this.custId = custId;
		this.name = name;
		this.mobile = mobile;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Customer [mobile=" + mobile + ", custId=" + custId + ", name="
				+ name + "]";
	}

}
