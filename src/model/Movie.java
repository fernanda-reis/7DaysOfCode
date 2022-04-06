package model;

import interfaces.Content;

public class Movie implements Content {

	private String title;
	private String urlImage;
	private String rating; 
	private String year;
	

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
	@Override
	public String title() {
		// TODO Auto-generated method stub
		return title;
	}
	@Override
	public String urlImage() {
		// TODO Auto-generated method stub
		return urlImage;
	}
	@Override
	public String rating() {
		// TODO Auto-generated method stub
		return rating;
	}
	@Override
	public String year() {
		// TODO Auto-generated method stub
		return year;
	}
	
	
}
