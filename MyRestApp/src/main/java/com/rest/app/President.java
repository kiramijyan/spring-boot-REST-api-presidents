package com.rest.app;

public class President {
	
	private String firstName;
	private String lastName;
	private int startYear;
	private int endYear;
	private int number;
	
	private static int count;
	
	public President(String firstName, String lastName, int startYear, int endYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.startYear = startYear;
		this.endYear = endYear;
		
		count++;
		this.number = count;
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

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public int getNumber() {
		return number;
	}
	
	
}
