package com.tejas.springxml.pojo;

public class Department {
	
	private String deptname;
	private String deptid;
	private Integer noofemployees;
	
	
	
	
	
	public Department() {
		super();
	}


	public Department(String deptname, String deptid, Integer noofemployees) {
		super();
		this.deptname = deptname;
		this.deptid = deptid;
		this.noofemployees = noofemployees;
	}
	
	
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public Integer getNoofemployees() {
		return noofemployees;
	}
	public void setNoofemployees(Integer noofemployees) {
		this.noofemployees = noofemployees;
	}
	
	
	

}
