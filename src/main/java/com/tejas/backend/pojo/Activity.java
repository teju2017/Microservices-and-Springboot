package com.tejas.backend.pojo;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activitylist")
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="actid")
	private Long activityid;
	
	@Column(name="actcategory")
	private String activitycategory;
	
	@Column(name="actdesc")
	private String activitydesc;
	
	@Column(name="actdate")
	private Date activitydate;
	
	
	public Activity() {
		
	}

	public Activity(String activitycategory, String activitydesc, Date activitydate) {
		super();
		this.activitycategory = activitycategory;
		this.activitydesc = activitydesc;
		this.activitydate = activitydate;
	}
	
	/**
	 * @return the activityid
	 */
	public Long getActivityid() {
		return activityid;
	}
	/**
	 * @param activityid the activityid to set
	 */
	public void setActivityid(Long activityid) {
		this.activityid = activityid;
	}
	/**
	 * @return the activitycategory
	 */
	public String getActivitycategory() {
		return activitycategory;
	}
	/**
	 * @param activitycategory the activitycategory to set
	 */
	public void setActivitycategory(String activitycategory) {
		this.activitycategory = activitycategory;
	}
	/**
	 * @return the activitydesc
	 */
	public String getActivitydesc() {
		return activitydesc;
	}
	/**
	 * @param activitydesc the activitydesc to set
	 */
	public void setActivitydesc(String activitydesc) {
		this.activitydesc = activitydesc;
	}
	/**
	 * @return the activitydate
	 */
	public Date getActivitydate() {
		return activitydate;
	}
	/**
	 * @param activitydate the activitydate to set
	 */
	public void setActivitydate(Date activitydate) {
		this.activitydate = activitydate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activitycategory, activitydate, activitydesc, activityid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Activity)) {
			return false;
		}
		Activity other = (Activity) obj;
		return Objects.equals(activitycategory, other.activitycategory)
				&& Objects.equals(activitydate, other.activitydate) && Objects.equals(activitydesc, other.activitydesc)
				&& Objects.equals(activityid, other.activityid);
	}
	
	
	
	

}
