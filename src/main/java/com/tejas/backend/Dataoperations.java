package com.tejas.backend;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tejas.backend.pojo.UserDetails;
import com.tejas.backend.pojo.UserDetailsRepository;


@Service
public class Dataoperations {
	
	@Autowired
    private UserDetailsRepository userobj1;
    
    

	public void saveval(UserDetails userobjparam)
	{
		System.out.println("Name = "+userobjparam.getUsername()+" City = "+userobjparam.getCity());
		System.out.println("Userobj value is "+userobj1);
		this.userobj1.save(userobjparam);
	}
	
	public void delete(Integer id)
	{
		this.userobj1.deleteById(id);
	}
	
	
	public List<UserDetails> getall()
	{
		return userobj1.findAll();
	}

}
