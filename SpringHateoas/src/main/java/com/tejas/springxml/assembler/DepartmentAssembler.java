package com.tejas.springxml.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.tejas.springxml.pojo.Department;
import com.tejas.springxml.pojo.Employee;

@Component
public class DepartmentAssembler implements RepresentationModelAssembler<Department,EntityModel<Department>>
{

	@Override
	public EntityModel<Department> toModel(Department entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
