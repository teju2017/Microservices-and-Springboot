package com.tejas.backend;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.tejas.backend.pojo.Activity;
import com.tejas.backend.pojo.ActivityDetails;
import com.tejas.backend.pojo.UserDetails;
import com.tejas.backend.pojo.UserDetailsRepository;
import com.tejas.backend.pojo.WorkExperience;
import com.tejas.backend.pojo.WorkExperienceRepository;

@SpringBootTest
//@DataJpaTest
class BackendDatabaseLoadingApplicationTests {
	
	@Autowired
	UserDetailsRepository userobjval;
	
	@Autowired
	WorkExperienceRepository workobj;
	
	
	@Autowired
	ActivityDetails activityobject;


	@Test
	void testUserDetails() {
		UserDetails usr = new UserDetails("sddf", "dsfd", "dfd", "dfds","dsfdsf");
		userobjval.save(usr);
		
		
	}

	@Test
	public void testexperiencetable()
	{
		workobj.save(new WorkExperience("AOL","Bengaluru",6));
		workobj.save(new WorkExperience("Capegemini","Bengaluru",17));
		workobj.save(new WorkExperience("HCL","Bengaluru and Singapore",21));
	}
	
	@Test
	public void testfindvalues()
	{
		List<WorkExperience> experiencelist=workobj.findAll();
		experiencelist.forEach((Workobj)->{ 
			                        System.out.println("employeeid= "+Workobj.getEmployeeid()+" Location ="+Workobj.getLocation()+" Company = "+Workobj.getCompanyname());
		}
		);
		
	}
	
	@Test
	@ParameterizedTest
	@ValueSource(longs = {7L,8L,9L})
	public void testFindbyId(Long l)
	{
		Optional<WorkExperience> opt= workobj.findById(l);
		System.out.println(opt.get().getCompanyname()+opt.get().getLocation()+opt.get().getEmployeeid()+opt.get().getMonths());
	}

	@Test
	@ParameterizedTest
	@ValueSource(longs = {16L,17L,18L})
	public void deleteFindbyid(Long deletionid)
	{
		workobj.deleteById(deletionid);
	}
	
	@Test
	public void saveactivitydetails()
	{
		java.util.Date dateutil = new java.util.Date();
		java.sql.Date dt = new Date(dateutil.getTime());
		activityobject.save(new Activity("exercise", "walking",dt));
		activityobject.save(new Activity("exercise1", "walking",dt));
		activityobject.save(new Activity("exercise2", "walking",dt));
		activityobject.save(new Activity("exercise3", "walking",dt));
		activityobject.save(new Activity("exercise4", "walking",dt));
		activityobject.save(new Activity("exercise5", "walking",dt));
		
	}
	
	@Test
	@ParameterizedTest
	@ValueSource(longs = {1L,5L,7L})
	public void activitydetails(Long actid)
	{
		System.out.println("Activity values are ");
		Optional<Activity> optact=activityobject.findById(actid);
		System.out.println("ID = "+optact.get().getActivityid()+" Category = "+optact.get().getActivitycategory()+" Description = "+optact.get().getActivitydesc());

	}
	
	@Test
	@ParameterizedTest
	@ValueSource(longs = {2L,4L,6L,8L})
	public void activitydelete(Long deleteid)
	{
		System.out.println("Delete the id by active "+deleteid);
		if(activityobject.findById(deleteid).isPresent())
		{
			activityobject.deleteById(deleteid);
		}
		else
		{
			
			System.out.println("ID "+deleteid+" not present");
		}
		
		
	}
	
	
	
}
