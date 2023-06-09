package com.techhub.kafka.dto;

public class Student{

	
	public String studenId;
	public String name;
	public int rollNo;
	public Address address;

	public Student() {
	}

	public Student(String studenId, String name, int rollNo) {
		super();
		this.studenId = studenId;
		this.name = name;
		this.rollNo = rollNo;
	}

	public Student(String studenId, String name, int rollNo, Address address) {
		super();
		this.studenId = studenId;
		this.name = name;
		this.rollNo = rollNo;
		this.address = address;
	}

	public String getStudenId() {
		return studenId;
	}

	public void setStudenId(String studenId) {
		this.studenId = studenId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studenId=" + studenId + ", name=" + name + ", rollNo=" + rollNo + ", address=" + address + "]";
	}
}
