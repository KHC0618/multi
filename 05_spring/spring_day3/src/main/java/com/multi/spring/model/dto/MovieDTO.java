package com.multi.spring.model.dto;

public class MovieDTO {
	private String title;
	private String price;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "MovieDTO [title=" + title + ", price=" + price + "]";
	}
	
}
