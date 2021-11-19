package com.tejas.microservices.Controller;




import java.net.URI;

import java.net.URL;
import java.net.http.HttpResponse;

import org.apache.tomcat.jni.User;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.user.UserDestinationMessageHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.tejas.microservices.*;
import com.tejas.microservices.Pojo.InformationPage;
import com.tejas.microservices.Pojo.UserDetails;

@Controller
public class Controllerwork {
	
	
	@Bean
	public RestTemplate getresttemplate()
	{
		return new RestTemplate();
	}
	
	@Autowired
	public RestTemplate resttemplate;
	
	
	@GetMapping("/")
	public String getpage()
	{
		return "Pageone";
	}
	
	@GetMapping("/pageinfo")
	public String putinformation(@ModelAttribute("information") InformationPage inforobj,ModelMap model) throws Exception
	{
		System.out.println("Values displayed are "+inforobj.getCity()+" Name ="+inforobj.getUsername()+" Hobbies = "+inforobj.getHobbies());
		model.put("name",inforobj.getUsername());
		model.put("hobbies",inforobj.getHobbies());
		model.put("City",inforobj.getCity());
		model.put("AOF",inforobj.getAreaofinterest());
		/*
		 * StringBuilder strbuilder = new StringBuilder(inforobj.getUsername());
		 * strbuilder.append(inforobj.getCity());
		 * strbuilder.append(inforobj.getHobbies());
		 * strbuilder.append(inforobj.getAreaofinterest()); String
		 * urlval="http://localhost:9090/test/userdetails"; java.net.URI url = new
		 * java.net.URI(urlval); JSONPObject jsonobj = new JSONPObject("userinfo",
		 * inforobj); resttemplate.put(urlval, jsonobj.getValue());
		 */
		
		String urlval="http://localhost:9090/addperson";
		UserDetails user = new UserDetails(inforobj.getUsername(), inforobj.getHobbies(), inforobj.getCity(), inforobj.getAreaofinterest(), "POST");
		
		RestTemplate restTemplate = new RestTemplate();
	    org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    HttpEntity<UserDetails> request = new HttpEntity<>(user,headers);
        URI uri = new URI(urlval);
        String personResultAsJsonStr = 
			      resttemplate.postForObject(urlval, request,String.class);
			    System.out.println("Return value is "+personResultAsJsonStr);
			    
         if(personResultAsJsonStr.equalsIgnoreCase("Success"))
         {
        	 return "Success";
         }
			    
		
		return "info";
	}
	
	
	@GetMapping("/error")
	public String genericerrorhandler(ModelMap model)
	{
		return "error";
	}

}
