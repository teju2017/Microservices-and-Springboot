package com.tejas.testClient;

import java.net.URL;
import java.rmi.Remote;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.rpc.Call;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.TypeMappingRegistry;
import javax.xml.rpc.handler.HandlerRegistry;

import com.tejas.generatedcode.StudentDetailsPort;
import com.tejas.generatedcode.StudentDetailsPortService;
import com.tejas.generatedcode.StudentDetailsPortServiceLocator;
import com.tejas.generatedcode.StudentDetailsRequest;
import com.tejas.generatedcode.StudentDetailsResponse;

public class TestClient {

	public TestClient() {
		
	}
	
	public static void main(String args[]) throws Exception
	{

		StudentDetailsPortServiceLocator locator = new StudentDetailsPortServiceLocator();
		StudentDetailsPort port = (StudentDetailsPort)locator.getStudentDetailsPortSoap11();
		
		
		StudentDetailsRequest requestobj = new StudentDetailsRequest();
		requestobj.setName(args[0]);
		
		StudentDetailsResponse resp = port.studentDetails(requestobj);
		
		System.out.println("Response value is  Name ="+resp.getStudent().getName()+"~~~~~ Address ="+resp.getStudent().getAddress()+"~~~~~ Standard="+resp.getStudent().getStandard());
		
		
	}

}
