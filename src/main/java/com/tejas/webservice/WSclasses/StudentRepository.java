package com.tejas.webservice.WSclasses;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
// import com.tejas.xml.school.Student;
import com.tejas.webservice.WSclasses.*;
 
@Component
public class StudentRepository {
    private static final Map<String, Student> students = new HashMap<>();
 
    @PostConstruct
    public void initData() {
         
        Student student = new Student();
        student.setName("Sajal");
        student.setStandard(5);
        student.setAddress("Pune");
        students.put(student.getName(), student);
         
        student = new Student();
        student.setName("Kajal");
        student.setStandard(5);
        student.setAddress("Chicago");
        students.put(student.getName(), student);
         
        student = new Student();
        student.setName("Lokesh");
        student.setStandard(6);
        student.setAddress("Delhi");
        students.put(student.getName(), student);
         
        student = new Student();
        student.setName("Sukesh");
        student.setStandard(7);
        student.setAddress("Noida");
        students.put(student.getName(), student);
        
        student = new Student();
        student.setName("Tejas");
        student.setStandard(37);
        student.setAddress("Hassan");
        students.put(student.getName(), student);
    }
    
    
    public Student dummyinsert(String name)
    {
    	Student st= new Student();
        st.setName("Name passed "+name +" not found");
        st.setAddress("Not found");
        st.setStandard(404);
        return st;
    }
 
    public Student findStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        return students.getOrDefault(name,dummyinsert(name));
    }
}