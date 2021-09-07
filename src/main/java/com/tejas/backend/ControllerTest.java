package com.tejas.backend;

import java.lang.System.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.backend.pojo.UserDetails;
import com.tejas.backend.pojo.UserDetailsRepository;

@RestController
public class ControllerTest {
	
	
	@Autowired
	private UserDetailsRepository userobj;
	
	@Autowired
	private Dataoperations dataops;
	
	private java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ControllerTest.class.getName());
	
	@GetMapping("/test")
	public String checksomevalue()
	{
		dataops.saveval(new UserDetails("Tejas","Avyukth", "Goodone", "Goodtwo","Goodthree"));
		userobj.save(new UserDetails("sddf", "dsfd", "dfd", "dfds","dsfdsf"));
		return "working";
	}
	
	
	@PostMapping(value = "/addperson",consumes = "application/json")
	public String databaseloading(@RequestBody UserDetails userdetails)
	{
		int flag=0;
		UserDetails userret=userobj.save(userdetails);
		if(userret != null)
		{
			logger.info("Insertion successful");
			flag=1;
		}
		else
		{
			logger.warning("Insertion failed");
		}
		
	if(flag==1)
	{
		return "success";
	}
	else
	{
		return "fail";
	}
		
	}
	
	
	
	
	

}
