package com.jsp.controller;

import com.jsp.dao.StudentDemo;


public class TestUpdate {
	public static void main(String[] args) {
		
		StudentDemo studao = new StudentDemo();
		String email= "jaypatill8833@gmail.com";
		boolean up = studao.updateStudentById(1, email);
		System.out.println("done");
		
	}

}
