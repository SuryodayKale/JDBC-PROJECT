package com.jsp.controller;

import java.util.List;

import com.jsp.dao.StudentDemo;
import com.jsp.dto.Student;

public class GetAll {
	
	public static void main(String[] args) {
		StudentDemo studentDemo=new StudentDemo();
	   List<Student>al= studentDemo.getAllStudents();
	   
	   
	   for(Student s : al) {
		  System.out.println(s.getId());
		  System.out.println(s.getName());
		  System.out.println(s.getEmail());
		  System.out.println("===============");
	   }
	}

}
