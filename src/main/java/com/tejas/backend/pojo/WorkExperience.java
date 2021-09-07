package com.tejas.backend.pojo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="experience")
public class WorkExperience {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private Long employeeid;
	
	@Column(name="Cname")
	private String companyname;
	
	@Column(name="loc")
	private String location;
	
	@Column(name="durationinmonths")
	private Integer   months;
	
	

	public WorkExperience() {
		super();
	}

	public WorkExperience(String companyname, String location, Integer months) {
		super();
		this.companyname = companyname;
		this.location = location;
		this.months = months;
	}

	/**
	 * @return the employeeid
	 */
	public Long getEmployeeid() {
		return employeeid;
	}

	/**
	 * @param employeeid the employeeid to set
	 */
	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}

	/**
	 * @return the companyname
	 */
	public String getCompanyname() {
		return companyname;
	}

	/**
	 * @param companyname the companyname to set
	 */
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the months
	 */
	public Integer getMonths() {
		return months;
	}

	/**
	 * @param months the months to set
	 */
	public void setMonths(Integer months) {
		this.months = months;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyname, employeeid, location, months);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof WorkExperience)) {
			return false;
		}
		WorkExperience other = (WorkExperience) obj;
		return Objects.equals(companyname, other.companyname) && Objects.equals(employeeid, other.employeeid)
				&& Objects.equals(location, other.location) && Objects.equals(months, other.months);
	}

	@Override
	public String toString() {
		return "WorkExperience [employeeid=" + employeeid + ", companyname=" + companyname + ", location=" + location
				+ ", months=" + months + "]";
	}
	
	
	
	
	
	
	
	
	

}
