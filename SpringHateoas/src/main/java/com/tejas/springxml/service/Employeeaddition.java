package com.tejas.springxml.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tejas.springxml.exception.EmployeeValue;
import com.tejas.springxml.exception.Employeenamenotfound;
import com.tejas.springxml.pojo.Employee;

@Component
@Service
public class Employeeaddition {
	
	
	private static List<Employee> listofemp;
	private Employee e;
	
	
	
	public Employeeaddition()
	{
		 listofemp = new ArrayList<Employee>();
	}
	
	public Boolean employeeadd(Employee e)
	{
		if(e.getEmpid() != null && e.getName() != null && e.getSalary() != null)
		{
			System.out.println("Added successfully ");
			listofemp.add(e);
			return true;
		}
		return false;
	}
	
	
	public static void employeeaddition()
	{
		listofemp = new ArrayList<Employee>();
		Employee e[] = new Employee[3];
		e[0]=new Employee("emp_name1", "emp1_id",Double.valueOf(123.45));
		e[1]=new Employee("emp_name2", "emp2_id",Double.valueOf(123456.45));
		e[2]=new Employee("emp_name3", "emp3_id",Double.valueOf(12334.45));
		listofemp.add(e[0]);
		listofemp.add(e[1]);
		listofemp.add(e[2]);
		System.out.println("Employee list added , size is "+listofemp.size());
	}
	
	public List<Employee> getlistofemployees()
	{
	
		return listofemp;
	}
	
	public void employeeclean()
	{
		listofemp.clear();
	}
	
	public Boolean empdelete(String empid)
	{
		System.out.println("Size of listnum before removal is "+listofemp.size());
		 List<Employee> list = new ArrayList<Employee>();
		 int index=0;
		 boolean removeops;
	    listofemp.forEach((x) ->
	    {
	    	if(x.getEmpid().equals(empid))
	    	{
	    		System.out.println("Index value of empid "+empid+ " is "+listofemp.indexOf(x));
	    		list.add(x);
	    	}
	    });
	    
	    
	    if(list.size() > 0 )
	    {
	    	list.forEach((num) ->
	    	{
	    		listofemp.remove(num);
	    	});
	    	
	    	System.out.println("Size of listnum after removal is "+listofemp.size());
	    		
	    	return true;
	    }
	    System.out.println("empid passed doesnt exist and hence exiting");
	    return false;
	    
		
	}
	
	
	
	public Employee getemployee(String id)
	{
		
		e=null;
        listofemp.forEach((x) ->
        {
        	if(x.getName().equalsIgnoreCase(id))
        	{
        		e=x;
        	}
        }
        );
        if(e == null)
        	{
        	    System.out.println("Employee object e is null");
        	    throw new Employeenamenotfound();
        	}
        return e;
        
                 
                   
                   
	}

}
