package com.promostree.domain.entities;

public class User {
	
	private String searchTerm;
	private Double lat;
	private Double lng;
	private Double radius;
	private int pageNumber;
	

	public String getSearchTerm() {
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		if(searchTerm!=null)
		this.searchTerm = searchTerm.toLowerCase();
		else
			this.searchTerm = searchTerm;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getRadius() {
		return radius;
	}
	public void setRadius(Double radius) {
		this.radius = radius;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "User [searchTerm=" + searchTerm + ", lat=" + lat + ", " + "lng=" + lng + "radius=" + radius + "]";
	}
	

}
