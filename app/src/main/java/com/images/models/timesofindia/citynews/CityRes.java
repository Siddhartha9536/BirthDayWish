package com.images.models.timesofindia.citynews;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class CityRes{

	@SerializedName("Item")
	private List<ItemItemCity> item;

	public void setItem(List<ItemItemCity> item){
		this.item = item;
	}

	public List<ItemItemCity> getItem(){
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