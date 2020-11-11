package com.jspiders.studentapp.database;

import com.jspiders.studentapp.beans.StudentBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDB { 

	public static int save(StudentBean bean){
		
		int status=0;
		try{
			Connection con=ConnectionProvider.giveConnection();
			PreparedStatement ps=con.prepareStatement("insert into student(name,email,gender,course,fee,paid,due,address,contact) "
					+ " values(?,?,?,?,?,?,?,?,?) ");
			
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getGender());
			ps.setString(4,bean.getCourse());
			ps.setDouble(5,bean.getFee());
			ps.setDouble(6,bean.getPaid());
			ps.setDouble(7,bean.getDue());
			ps.setString(8,bean.getAddress());
			ps.setString(9,bean.getContact());
			
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return status;
	}
	
	public static int update(StudentBean bean){
		
		int status=0;
		try{
			Connection con=ConnectionProvider.giveConnection();
			PreparedStatement ps=con.prepareStatement(" update student "
					+ " set name=?,email=?,gender=?,course=?,fee=?,paid=?,due=?,address=?,contact=? "
					+ " where regno=? ");
			
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getGender());
			ps.setString(4,bean.getCourse());
			ps.setDouble(5,bean.getFee());
			ps.setDouble(6,bean.getPaid());
			ps.setDouble(7,bean.getDue());
			ps.setString(8,bean.getAddress());
			ps.setString(9,bean.getContact());
			ps.setInt(10,bean.getRegno());
			
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return status;
	}	
	
	public static int delete(int regno){
		
		int status=0;
		try{
			Connection con=ConnectionProvider.giveConnection();
			PreparedStatement ps=con.prepareStatement(" delete from student where regno=? ");
			ps.setInt(1,regno);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return status;
	}
	
	public static int deleteByName(String name){
	
		int status=0;
		try{
			Connection con=ConnectionProvider.giveConnection();
			PreparedStatement ps=con.prepareStatement(" delete from student where name=? ");
			ps.setString(1,name);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return status;
	}

	public static List<StudentBean> getAllRecords(){
		
		List<StudentBean> list=new ArrayList<StudentBean>();
		try{
			Connection con=ConnectionProvider.giveConnection();
			PreparedStatement ps=con.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				StudentBean bean=new StudentBean();
				bean.setRegno(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setGender(rs.getString(4));
				bean.setCourse(rs.getString(5));
				bean.setFee(rs.getDouble(6));
				bean.setPaid(rs.getDouble(7));
				bean.setDue(rs.getDouble(8));
				bean.setAddress(rs.getString(9));
				bean.setContact(rs.getString(10));
				list.add(bean);
			}
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return list;
	}
	
	public static List<StudentBean> getDues(){
		
		List<StudentBean> list=new ArrayList<StudentBean>();
		try{
			Connection con=ConnectionProvider.giveConnection();
			PreparedStatement ps=con.prepareStatement(" select * from student where due>0 ");
			ResultSet rs=ps.executeQuery();
		
			while(rs.next()){
				StudentBean bean=new StudentBean();
				bean.setRegno(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setGender(rs.getString(4));
				bean.setCourse(rs.getString(5));
				bean.setFee(rs.getDouble(6));
				bean.setPaid(rs.getDouble(7));
				bean.setDue(rs.getDouble(8));
				bean.setAddress(rs.getString(9));
				bean.setContact(rs.getString(10));
				list.add(bean);
			}
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return list;
	}

	public static StudentBean getRecordByRegno(int regno){
		
		StudentBean bean=new StudentBean();
		try{
			Connection con=ConnectionProvider.giveConnection();
			PreparedStatement ps=con.prepareStatement("select * from student where regno=?");
			ps.setInt(1,regno);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				bean.setRegno(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setGender(rs.getString(4));
				bean.setCourse(rs.getString(5));         
				bean.setFee(rs.getDouble(6));
				bean.setPaid(rs.getDouble(7));
				bean.setDue(rs.getDouble(8));
				bean.setAddress(rs.getString(9));
				bean.setContact(rs.getString(10));
			}
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return bean;
	}
}
