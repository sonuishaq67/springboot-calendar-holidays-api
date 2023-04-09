package com.sonuishaq67.caldb.model;

import java.util.ArrayList;

public class Day {
	int date;
	String day;
	ArrayList<String> events= new ArrayList<String>();
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public ArrayList<String> getEvents() {
		return events;
	}
	public void setEvents(ArrayList<String> events) {
		this.events = events;
	}
	
	
}
