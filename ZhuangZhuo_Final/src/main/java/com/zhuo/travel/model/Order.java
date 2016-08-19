package com.zhuo.travel.model;

import java.util.HashSet;
import java.util.Set;

public class Order {
private Integer orderID;
private Integer peopleNum;
private Integer tripID;
private Integer uid;
private String destination;

	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public Integer getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}
	public Integer getTripID() {
		return tripID;
	}
	public void setTripID(Integer tripID) {
		this.tripID = tripID;
	}
	
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

}
