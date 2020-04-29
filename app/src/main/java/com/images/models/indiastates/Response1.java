package com.images.models.indiastates;


import com.google.gson.annotations.SerializedName;

public class Response1 {

	@SerializedName("recovered")
	private String recovered;

	@SerializedName("isoCode")
	private String isoCode;

	@SerializedName("name")
	private String name;

	@SerializedName("active")
	private int active;

	@SerializedName("id")
	private int id;

	@SerializedName("value")
	private int value;

	@SerializedName("confirmed")
	private String confirmed;

	@SerializedName("deaths")
	private String deaths;

	public void setRecovered(String recovered){
		this.recovered = recovered;
	}

	public String getRecovered(){
		return recovered;
	}

	public void setIsoCode(String isoCode){
		this.isoCode = isoCode;
	}

	public String getIsoCode(){
		return isoCode;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setActive(int active){
		this.active = active;
	}

	public int getActive(){
		return active;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setValue(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	public void setConfirmed(String confirmed){
		this.confirmed = confirmed;
	}

	public String getConfirmed(){
		return confirmed;
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
			"Response{" + 
			"recovered = '" + recovered + '\'' + 
			",isoCode = '" + isoCode + '\'' + 
			",name = '" + name + '\'' + 
			",active = '" + active + '\'' + 
			",id = '" + id + '\'' + 
			",value = '" + value + '\'' + 
			",confirmed = '" + confirmed + '\'' + 
			",deaths = '" + deaths + '\'' + 
			"}";
		}
}