package com.images.models.indiaStatewise;

import com.google.gson.annotations.SerializedName;

public class Covid19India{

	@SerializedName("recovered")
	private String recovered;

	@SerializedName("cases")
	private String cases;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("deaths")
	private String deaths;

	public void setRecovered(String recovered){
		this.recovered = recovered;
	}

	public String getRecovered(){
		return recovered;
	}

	public void setCases(String cases){
		this.cases = cases;
	}

	public String getCases(){
		return cases;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setDeaths(String deaths){
		this.deaths = deaths;
	}

	public String getDeaths(){
		return deaths;
	}

	@Override
 	public String toString(){
		return 
			"Covid19India{" + 
			"recovered = '" + recovered + '\'' + 
			",cases = '" + cases + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",deaths = '" + deaths + '\'' + 
			"}";
		}
}