package com.sonuishaq67.caldb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Holiday{
	 public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getObserved() {
			return observed;
		}
		public void setObserved(String observed) {
			this.observed = observed;
		}
		public boolean isMypublic() {
			return mypublic;
		}
		public void setMypublic(boolean mypublic) {
			this.mypublic = mypublic;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getUuid() {
			return uuid;
		}
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
		public Weekday getWeekday() {
			return weekday;
		}
		public void setWeekday(Weekday weekday) {
			this.weekday = weekday;
		}
	public String name;
	 public String date;
	 public String observed;
	 @JsonProperty("public") 
	 public boolean mypublic;
	 public String country;
	 public String uuid;
	 public Weekday weekday;
	}