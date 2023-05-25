package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.Student;
import com.jsp.helper.HelperClass;

public class StudentDemo {
         HelperClass helperClass = new HelperClass();
         Connection connection = null;
         
         public void addMultipleStudents(List<Student> student) {
        	 connection=helperClass.getConnection();
        	 String sql = "INSERT INTO student VALUES (?,?,?)";
        	 
        	 try {
        		 //create statement
				PreparedStatement  preparedStatement = connection.prepareStatement(sql);
				
				//execute statement
				for(Student s : student ) {
					preparedStatement.setInt(1, s.getId());
					preparedStatement.setString(2,s.getName());
					preparedStatement.setString(3 ,s.getEmail());
					
					preparedStatement.addBatch();
				}
				preparedStatement.executeBatch();// return type int
				System.out.println("All Good");
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
         }
         
         
         
     	public boolean deleteStudentById(int id) {
     		connection=helperClass.getConnection();
     		String sql="DELETE FROM student WHERE id=?";
     		boolean res = false;
     		
     		try {
     			PreparedStatement  preparedStatement= connection.prepareStatement(sql);
     			
     			preparedStatement.setInt(1,id);
     			
     			int res2= preparedStatement.executeUpdate();
     			if(res2>0) {
     				res=true;
     			}else {
     				res=false;
     			}
     		
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
     		return res;
     	}
     	
     	
	//save
	public Student saveStudent(Student student) {
		
		Connection connection= helperClass.getConnection();
		String sql="INSERT INTO student VALUES(?,?,?)"; //-delimiters/Place holder
		
		//Create statement
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setNString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally { 
	
			  try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		return student;
	}
	//get all
	public List<Student> getAllStudents(){
		connection = helperClass.getConnection();
		String sql = "SELECT * from student";
		ArrayList<Student> al = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = 	preparedStatement.executeQuery();
			al= new ArrayList<Student>();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				Student s = new Student();
				s.setId(id);
				s.setName(name);
				s.setEmail(email);
				al.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;

	}
	//update
	public boolean updateStudentById(int id,String email) {
		Connection connection = helperClass.getConnection();
		String sql =" UPDATE student SET email=?  WHERE id =?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, id);
			
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return true;
	}
	//get data by id
	
	public Student getStudentById(int id){
		Connection connection = helperClass.getConnection();
		String sql = "SELECT * FROM student WHERE ID = ?";
		Student student1 = new Student();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				int id1=resultSet.getInt(1);
				String name=resultSet.getString(2);
				String email=resultSet.getString(3);
				
				student1.setId(id1);
				student1.setEmail(email);
				student1.setName(name);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return student1;
	}
	
}
