package com.techhub.kafka.dto;

public class Address {

	private String locality;
	private String tehsil;
	private String district;
	private String state;
	private int pinCode;

	public Address() {
	}

	public Address(String locality, String tehsil, String district, String state, int pinCode) {
		super();
		this.locality = locality;
		this.tehsil = tehsil;
		this.district = district;
		this.state = state;
		this.pinCode = pinCode;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getTehsil() {
		return tehsil;
	}

	public void setTehsil(String tehsil) {
		this.tehsil = tehsil;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [locality=" + locality + ", tehsil=" + tehsil + ", district=" + district + ", state=" + state
				+ ", pinCode=" + pinCode + "]";
	}

}
