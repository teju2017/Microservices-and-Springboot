package com.tejas.springxml;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.core.TypeReferences.EntityModelType;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.tejas.springxml.assembler.EmployeeAssembler;
import com.tejas.springxml.exception.EmployeeValue;
import com.tejas.springxml.pojo.Employee;
import com.tejas.springxml.service.Employeeaddition;



@RestController
public class SimpleController {
	
	@Autowired
	public Employeeaddition empops;
	
	@Autowired
	public EmployeeAssembler assembler;
	
	@RequestMapping(value = "/version",method = RequestMethod.GET)
	public ResponseEntity<String> getVersion()
	{
		return new ResponseEntity<>("working ok",HttpStatus.OK);
	}
	
	@RequestMapping(value="/emplist", method = RequestMethod.GET)
	public CollectionModel<EntityModel<Employee>> getemplist()
	{
		List<Employee> list = empops.getlistofemployees(); 
		if(assembler == null)
		{
			System.out.println("Assembler is empty");
		}
		
		
		List<EntityModel<Employee>> empmodel = empops.getlistofemployees()
				                                     .stream()
				                                     .map(assembler::toModel)
				                                     .collect(Collectors.toList());
		
		empmodel.forEach((x) -> 
		{
			System.out.println("Content value = "+x.getContent().getEmpid());
		});
		
		CollectionModel<EntityModel<Employee>> collectionModel = CollectionModel.of(empmodel);
		collectionModel.add(linkTo(methodOn(SimpleController.class).getemplist()).withSelfRel());
		
		if(collectionModel == null)
		{
			System.out.println("collection model is empty");
		}
		
		return collectionModel;
		
	}
	
	@RequestMapping(value="/emplist/{id}",method=RequestMethod.GET)
	public ResponseEntity<EntityModel<Employee>> getemployeevalue(@PathVariable String id)
	{
		Employee e = empops.getemployee(id);
		EntityModel<Employee> entity  = assembler.toModel(e);
		return new ResponseEntity<EntityModel<Employee>>(entity,HttpStatus.OK);
	}
	
	@PostMapping(value="/empadd",consumes = {"application/json"})
	public ResponseEntity<String> postemployee(@RequestBody Employee e)
	{
	    if(!empops.employeeadd(e))
	    {
	    	throw new EmployeeValue();
	    }
		return new ResponseEntity<String>("EMPLOYEE ADDED SUCCESSFULLY ",HttpStatus.OK);
	}
	
	@RequestMapping(value="/empdel/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteemployee(@PathVariable("id") String empid)
	{
		Boolean b=empops.empdelete(empid);
		if(b)
		{
			return new ResponseEntity<String>("EMPLOYEE SUCCESSFULLY REMOVED FROM THE CACHE ",HttpStatus.OK);
		}
		return new ResponseEntity<String>("EMPLOYEE ID "+empid+" Deletion has failed ",HttpStatus.OK);
	}
	


}
