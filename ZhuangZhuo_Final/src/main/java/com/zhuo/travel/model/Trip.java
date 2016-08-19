package com.zhuo.travel.model;

import java.util.Date;

public class Trip {
	private Integer tripID;
	private String destination;
	private Float price;
	private Date dateFrom;
	private Date dateTo;
	private Integer maxAge;
	private Integer minAge;
	private String maxpeo;
	private String availpeo;
	private String itinerarys;
	private Integer agentID;
	private Integer month;
	private Integer year;
	private String overview;
	private String title;
	private String picurl;
	
	public Integer getTripID() {
		return tripID;
	}

	public void setTripID(Integer tripID) {
		this.tripID = tripID;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	

	public Integer getMaxAge() {
		return maxAge;
	}

	public Integer getMinAge() {
		return minAge;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	
	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}


	public String getMaxpeo() {
		return maxpeo;
	}

	public void setMaxpeo(String maxpeo) {
		this.maxpeo = maxpeo;
	}


	public String getAvailpeo() {
		return availpeo;
	}

	public void setAvailpeo(String availpeo) {
		this.availpeo = availpeo;
	}

	public String getItinerarys() {
		return itinerarys;
	}

	public void setItinerarys(String itinerarys) {
		this.itinerarys = itinerarys;
	}

	public Integer getAgentID() {
		return agentID;
	}

	public void setAgentID(Integer agentID) {
		this.agentID = agentID;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	
}
