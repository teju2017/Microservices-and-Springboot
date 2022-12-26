package com.tejas.springxml;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.List;

import com.tejas.springxml.assembler.EmployeeAssembler;
import com.tejas.springxml.pojo.Employee;
import com.tejas.springxml.service.Employeeaddition;


@WebMvcTest(controllers=SimpleController.class)
class SpringHateoasExampleTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	SimpleController simplecontroller;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	private Employeeaddition employeeAddition;
	
	@MockBean
	private EmployeeAssembler employeeAssembler;
	
	@MockBean
	private Employee employee;
	
	private CollectionModel<EntityModel<Employee>> collectionModel;
	
	
	
	@Before
	public void setUp()
	{
		this.mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		Employee emp = new Employee();
		emp.setEmpid("1234");
		emp.setName("Tejas");
		emp.setSalary(234.45);
		List<Employee> emplist = new ArrayList<Employee>();
		emplist.add(emp);
		EntityModel<Employee> entitymodel=employeeAssembler.toModel(emp);
		collectionModel = (CollectionModel<EntityModel<Employee>>) CollectionModel.of(entitymodel);
		collectionModel.add(linkTo(methodOn(SimpleController.class).getemplist()).withSelfRel());
		
		
		
		when(simplecontroller.getemplist()).thenReturn(collectionModel);
     }
	
	@Test
	public void testRun() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/emplist")
				                               .accept(MediaType.APPLICATION_JSON))
		                                       .andExpect(status().isOk());
		
		
		  mockMvc.perform(MockMvcRequestBuilders.get("/emplist")
		  .accept(MediaType.APPLICATION_JSON)) .andDo(print());
		 
		
		
			/*
			 * mockMvc.perform(MockMvcRequestBuilders.get("/emplist")
			 * .accept(MediaType.APPLICATION_JSON)) .andExpect((ResultMatcher)
			 * collectionModel);
			 */
		 
	}
	
	@Test
	public void addEmployee()
	{
		/*
		 * mockMvc.perform(MockMvcRequestBuilders.post("/empadd")
		 * .accept(MediaType.APPLICATION_JSON))
		 */
		
	}

}
