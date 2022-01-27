package com.thbs.bean_classes;

import java.io.Serializable;
@SuppressWarnings("serial")
public class PassengerBean implements Serializable{
	
	private String pname,age,gender,traveldate;


	public PassengerBean() {
		super();
	}
	public PassengerBean(String pname, String age, String gender, String traveldate) {
		super();
		this.pname = pname;
		this.age = age;
		this.gender = gender;
		this.traveldate = traveldate;
	}
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTraveldate() {
		return traveldate;
	}

	public void setTraveldate(String traveldate) {
		this.traveldate = traveldate;
	}
}

   
	