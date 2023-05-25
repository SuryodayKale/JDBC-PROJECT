package com.jsp.controller;

import java.util.ArrayList;

import com.jsp.dao.StudentDemo;
import com.jsp.dto.Student;

public class AddMultipleStudent {
	public static void main(String[] args) {
		
		StudentDemo studentdao = new StudentDemo();
		ArrayList<Student> al = new ArrayList<>();
		
		Student s = new Student();
		s.setId(2);
		s.setName("tanmay");
		s.setEmail("xyz@gmail.com");
		

		Student s1 = new Student();
		s.setId(3);
		s.setName("krushna");
		s.setEmail("xyz@gmail.com");
		
		

		Student s2 = new Student();
		s.setId(4);
		s.setName("shambhu");
		s.setEmail("xyz@gmail.com");
		
		
		al.add(s2);
		al.add(s1);
		al.add(s);
		
		studentdao.addMultipleStudents(al);
	}

}
