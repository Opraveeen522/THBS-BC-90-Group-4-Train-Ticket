package com.thbs.bean_classes;
import java.io.*;
@SuppressWarnings("serial")
public class UserBean implements Serializable{
	private String uname,pword,fname,age,gender,mailid;
	private long phno;
	
	public UserBean() {
		super();
	}
	public UserBean(String uname, String pword, String fname, String age, String gender, String mailid, long phno) {
		super();
		this.uname = uname;
		this.pword = pword;
		this.fname = fname;
		this.age = age;
		this.gender = gender;
		this.mailid = mailid;
		this.phno = phno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
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
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	
}