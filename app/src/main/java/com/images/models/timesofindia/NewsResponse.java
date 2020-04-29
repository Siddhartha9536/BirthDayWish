package com.images.models.timesofindia;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class NewsResponse{

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
			"NewsResponse{" + 
			"item = '" + item + '\'' + 
			"}";
		}
}