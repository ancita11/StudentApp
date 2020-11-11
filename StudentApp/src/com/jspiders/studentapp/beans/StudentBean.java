package com.jspiders.studentapp.beans;

public class StudentBean
{
      private int regno;
      private String name;
      private String email;
      private String gender;
      private String course;
      private double fee;
      private double paid;
      private double due;
      private String address;
      private String contact;
      
      public StudentBean() {
    	  
      }
      
      public StudentBean(int regno, String name, String email, String gender, String course, double fee, double paid,
    		  			 double due, String address, String contact) {
		
    	  this.regno = regno;
    	  this.name = name;
    	  this.email = email;
    	  this.gender = gender;
    	  this.course = course;
    	  this.fee = fee;
    	  this.paid = paid;
    	  this.due = due;
    	  this.address = address;
    	  this.contact = contact;
      }
	
      public StudentBean( String name, String email, String gender, String course, double fee, double paid,
    		  			  double due, String address, String contact) {
		
    	  this.name = name;
    	  this.email = email;
    	  this.gender = gender;
    	  this.course = course;
    	  this.fee = fee;
    	  this.paid = paid;
    	  this.due = due;
    	  this.address = address;
    	  this.contact = contact;
      }

      public int getRegno() {
    	  return regno;
      }
      public void setRegno(int regno) {
    	  this.regno = regno;
      }	
      public String getName() {
    	  return name;
      }
      public void setName(String name) {
    	  this.name = name;
      }
      public String getEmail() {
    	  return email;
      }
      public void setEmail(String email) {
    	  this.email = email;
      }
      public String getGender() {
    	  return gender;
      }
      public void setGender(String gender) {
    	  this.gender = gender;
      }
      public String getCourse() {
    	  return course;
      }
      public void setCourse(String course) {
    	  this.course = course;
      }
      public double getFee() {
    	  return fee;
      }
      public void setFee(double fee) {
    	  this.fee = fee;
      }
      public double getPaid() {
    	  return paid;
      }
      public void setPaid(double paid) {
    	  this.paid = paid;
      }
      public double getDue() {
    	  return due;
      }
      public void setDue(double due) {
    	  this.due = due;
      }
      public String getAddress() {
    	  return address;
      }
      public void setAddress(String address) {
    	  this.address = address;
      }
      public String getContact() {
    	  return contact;
      }
      public void setContact(String contact) {
    	  this.contact = contact;
      }
          
}
