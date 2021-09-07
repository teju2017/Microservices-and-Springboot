package com.tejas.backend;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.http.HttpHeaders;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.web.client.RestTemplate;

import com.tejas.backend.pojo.UserDetails;
import com.tejas.backend.pojo.UserDetailsRepository;


//@DataJpaTest
//@RestClientTest
@SpringBootTest
class RestTemplateTesting {
	
	
	@Autowired
	UserDetailsRepository userobjrep;
	
	
	private static RestTemplate resttemplate;
	
	
	/*@BeforeTestClass
	public static void runBeforeAllTestMethods() throws JSONException {
	    String addpersonurl = "http://localhost:8082/spring-rest/createPerson";
	    

	    resttemplate = new RestTemplate();
	    headers = new org.springframework.http.HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    UserDetails userobj = new UserDetails("sddsd", "sdfsfdsf", "sdfdsfdsf", "sddsfdsfd", "steerst");
	    JSONObject jsonobj = new JSONObject();
	    jsonobj.put("username", 1);
	    jsonobj.put("hobbies", "John");
	    jsonobj.put("city", "Hassan");
	    jsonobj.put("Areaofinterest", "Reading");
	    jsonobj.put("requesttype", "POST");
	    
	}*/
	

	/*@Test
	void testsave() {
		
		RestTemplate resttemplate = new RestTemplate();
		UserDetails userdetails = new UserDetails("microservices","sddsfsf","sdfdf","sdds","PUT");
		resttemplate.put("http://localhost:9090/test/addperson",userdetails);
		
	}*/
	
	
	@Test 
	void actualtest() throws Exception
	{
		 String addpersonurl = "http://localhost:9090/addperson";
		 UserDetails userobj = new UserDetails("Avyukth thejas Holalker", "Playing and shouting", "Hassan and Mumbai", "Unknown", "POST");
		 
		    resttemplate = new RestTemplate();
		    org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    
		    HttpEntity<UserDetails> request = new HttpEntity<>(userobj,headers);
            URI uri = new URI(addpersonurl);
		    
		    
			/*
			 * JSONObject jsonobj = new JSONObject(); jsonobj.put("username", 1);
			 * jsonobj.put("hobbies", "John"); jsonobj.put("city", "Hassan");
			 * jsonobj.put("Areaofinterest", "Reading"); jsonobj.put("requesttype", "POST");
			 */
			    
			    String personResultAsJsonStr = 
			      resttemplate.postForObject(addpersonurl, request,String.class);
			    System.out.println("Return value is "+personResultAsJsonStr);
			    assertEquals(personResultAsJsonStr,"success");
		

		   
			    
			
			    
			    /*JsonNode root = objectMapper.readTree(personResultAsJsonStr);
			    
			    assertNotNull(personResultAsJsonStr);
			    assertNotNull(root);
			    assertNotNull(root.path("name").asText());*/
	}

}
