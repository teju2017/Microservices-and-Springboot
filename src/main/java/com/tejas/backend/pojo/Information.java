package com.tejas.backend.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Information")
public class Information {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="hobbies")
	private String hobbies;
	
	@Column(name="city")
	private String city;
	
	@Column(name="Areaofint")
	private String Areaofinterest;
	
	@Column(name="requesttype")
	private String requesttype;
	
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the hobbies
	 */
	public String getHobbies() {
		return hobbies;
	}

	/**
	 * @param hobbies the hobbies to set
	 */
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the areaofinterest
	 */
	public String getAreaofinterest() {
		return Areaofinterest;
	}

	/**
	 * @param areaofinterest the areaofinterest to set
	 */
	public void setAreaofinterest(String areaofinterest) {
		Areaofinterest = areaofinterest;
	}

	/**
	 * @return the requesttype
	 */
	public String getRequesttype() {
		return requesttype;
	}

	/**
	 * @param requesttype the requesttype to set
	 */
	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}
	
	
	
	

}
