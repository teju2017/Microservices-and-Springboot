package com.tejas.springxml.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.tejas.springxml.SimpleController;
import com.tejas.springxml.pojo.Department;
import com.tejas.springxml.pojo.Employee;

@Component
public class EmployeeAssembler implements RepresentationModelAssembler<Employee,EntityModel<Employee>> {

	@Override
	public EntityModel<Employee> toModel(Employee entity) {
		EntityModel<Employee> employeemodel = EntityModel.of(entity);
		employeemodel.add(linkTo(methodOn(SimpleController.class).getemployeevalue(entity.getName())).withSelfRel());
		employeemodel.add(linkTo(methodOn(SimpleController.class).getemplist()).withRel(IanaLinkRelations.COLLECTION));
		employeemodel.add(linkTo(methodOn(SimpleController.class).deleteemployee(entity.getEmpid())).withSelfRel());
		employeemodel.add(linkTo(methodOn(SimpleController.class).postemployee(entity)).withRel(IanaLinkRelations.COLLECTION));
		return employeemodel;
	}

	


}
