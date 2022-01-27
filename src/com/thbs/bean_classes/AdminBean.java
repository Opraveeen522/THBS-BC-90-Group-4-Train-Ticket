package com.thbs.bean_classes;
import java.io.*;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
@SuppressWarnings("serial")
public class AdminBean implements Serializable{
	private String auname,apword,afname,amailid;
	private long aphno;
	
	public AdminBean() {
		super();
	}
	public AdminBean(String auname, String apword, String afname, String amailid, long aphno) {
		super();
		this.auname = auname;
		this.apword = apword;
		this.afname = afname;
		this.amailid = amailid;
		this.aphno = aphno;
	}
	public String getAuname() {
		return auname;
	}
	public void setAuname(String auname) {
		this.auname = auname;
	}
	public String getApword() {
		return apword;
	}
	public void setApword(String apword) {
		this.apword = apword;
	}
	public String getAfname() {
		return afname;
	}
	public void setAfname(String afname) {
		this.afname = afname;
	}
	public String getAmailid() {
		return amailid;
	}
	public void setAmailid(String amailid) {
		this.amailid = amailid;
	}
	public long getAphno() {
		return aphno;
	}
	public void setAphno(long aphno) {
		this.aphno = aphno;
	}
	
	
	
}