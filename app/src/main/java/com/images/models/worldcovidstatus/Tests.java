package com.images.models.worldcovidstatus;


import com.google.gson.annotations.SerializedName;

public class Tests{

	@SerializedName("total")
	private Object total;

	public void setTotal(Object total){
		this.total = total;
	}

	public Object getTotal(){
		return total;
	}

	@Override
 	public String toString(){
		return 
			"Tests{" + 
			"total = '" + total + '\'' + 
			"}";
		}
}