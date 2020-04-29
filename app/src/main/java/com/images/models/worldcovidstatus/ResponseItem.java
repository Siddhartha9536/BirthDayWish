package com.images.models.worldcovidstatus;

import com.google.gson.annotations.SerializedName;

public class ResponseItem{

	@SerializedName("country")
	private String country;

	@SerializedName("cases")
	private Cases cases;

	@SerializedName("tests")
	private Tests tests;

	@SerializedName("time")
	private String time;

	@SerializedName("day")
	private String day;

	@SerializedName("deaths")
	private Deaths deaths;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCases(Cases cases){
		this.cases = cases;
	}

	public Cases getCases(){
		return cases;
	}

	public void setTests(Tests tests){
		this.tests = tests;
	}

	public Tests getTests(){
		return tests;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setDay(String day){
		this.day = day;
	}

	public String getDay(){
		return day;
	}

	public void setDeaths(Deaths deaths){
		this.deaths = deaths;
	}

	public Deaths getDeaths(){
		return deaths;
	}

	@Override
 	public String toString(){
		return 
			"ResponseItem{" + 
			"country = '" + country + '\'' + 
			",cases = '" + cases + '\'' + 
			",tests = '" + tests + '\'' + 
			",time = '" + time + '\'' + 
			",day = '" + day + '\'' + 
			",deaths = '" + deaths + '\'' + 
			"}";
		}
}