package com.images.models.timesofindia.citynews;


import com.google.gson.annotations.SerializedName;


public class ItemItem{

	@SerializedName("category")
	private String category;

	@SerializedName("url")
	private String url;

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"ItemItem{" + 
			"category = '" + category + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}