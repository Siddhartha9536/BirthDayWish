package com.images.models.timesofindia.citynews;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class CityRes{

	@SerializedName("Item")
	private List<ItemItem> item;

	public void setItem(List<ItemItem> item){
		this.item = item;
	}

	public List<ItemItem> getItem(){
		return item;
	}

	@Override
 	public String toString(){
		return 
			"CityRes{" + 
			"item = '" + item + '\'' + 
			"}";
		}
}