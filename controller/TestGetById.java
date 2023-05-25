package com.jsp.controller;
import com.jsp.dao.StudentDemo;
import com.jsp.dto.Student;

public class TestGetById {
	public static void main(String[] args) {
		StudentDemo studao = new StudentDemo();
		Student s = studao.getStudentById(1);
		System.out.println(s.getId()+"    "+s.getEmail() + "    "+s.getName());
	}

}
