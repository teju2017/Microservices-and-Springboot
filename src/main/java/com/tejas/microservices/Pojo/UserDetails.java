package com.tejas.microservices.Pojo;

import java.util.Objects;


public class UserDetails {
	
	
	private String username;
	private String hobbies;
	private String city;
	private String Areaofinterest;
	private String requesttype;

	
	private Integer id;
	
	public UserDetails()
	{
		
	}

	public UserDetails(String username, String hobbies, String city, String areaofinterest, String requesttype){
		super();
		this.username = username;
		this.hobbies = hobbies;
		this.city = city;
		Areaofinterest = areaofinterest;
		this.requesttype = requesttype;
		//this.id = id;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAreaofinterest() {
		return Areaofinterest;
	}
	public void setAreaofinterest(String areaofinterest) {
		Areaofinterest = areaofinterest;
	}
	public String getRequesttype() {
		return requesttype;
	}
	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}
	 
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Areaofinterest, city, hobbies, id, requesttype, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserDetails)) {
			return false;
		}
		UserDetails other = (UserDetails) obj;
		return Objects.equals(Areaofinterest, other.Areaofinterest) && Objects.equals(city, other.city)
				&& Objects.equals(hobbies, other.hobbies) && Objects.equals(id, other.id)
				&& Objects.equals(requesttype, other.requesttype) && Objects.equals(username, other.username);
	}
	
	
   
	
	
	
		

}
