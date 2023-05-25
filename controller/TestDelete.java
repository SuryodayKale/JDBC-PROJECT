package com.jsp.controller;

import java.sql.SQLException;

import com.jsp.dao.StudentDemo;

public class TestDelete { 
	
	  public static void main(String[] args)  throws SQLException{
		StudentDemo student=new StudentDemo();
		
		boolean b = student.deleteStudentById(0);
		if(b) {
			System.out.println("data beleted");
		}else {
			System.out.println("data not deleted");
		}
	}
}
