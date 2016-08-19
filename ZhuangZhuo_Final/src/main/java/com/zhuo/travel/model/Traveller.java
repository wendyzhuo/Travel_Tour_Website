package com.zhuo.travel.model;

import java.util.Date;

public class Traveller {
private Integer travellerID;
private Integer orderID;
private Integer tripID;
private Integer userID;
private String firstName;
private String lastName;
private String email;
private String gender;
private String contactNum;
private Date dateofBirth;
public Integer getTravellerID() {
	return travellerID;
}
public void setTravellerID(Integer travellerID) {
	this.travellerID = travellerID;
}
public Integer getOrderID() {
	return orderID;
}
public void setOrderID(Integer orderID) {
	this.orderID = orderID;
}
public Integer getTripID() {
	return tripID;
}
public void setTripID(Integer tripID) {
	this.tripID = tripID;
}
public Integer getUserID() {
	return userID;
}
public void setUserID(Integer userID) {
	this.userID = userID;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
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
public String getContactNum() {
	return contactNum;
}
public void setContactNum(String contactNum) {
	this.contactNum = contactNum;
}
public Date getDateofBirth() {
	return dateofBirth;
}
public void setDateofBirth(Date dateofBirth) {
	this.dateofBirth = dateofBirth;
}

}
