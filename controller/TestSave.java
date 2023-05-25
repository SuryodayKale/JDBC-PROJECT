package com.jsp.controller;

import com.jsp.dao.StudentDemo;
import com.jsp.dto.Student;

public class TestSave {
    public static void main(String[] args) {
		Student student = new Student();
	
	student.setId(5);
	student.setName("sahil");
	student.setEmail("suryodaykale@gmail.com");
		
		
		StudentDemo studentDemo = new StudentDemo();
		Student s = studentDemo.saveStudent(student);
		System.out.println(s.getName() + "saved succesfully");
		
	}
}
