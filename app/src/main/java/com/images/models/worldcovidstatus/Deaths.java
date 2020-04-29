package com.images.models.worldcovidstatus;


import com.google.gson.annotations.SerializedName;


public class Deaths{

	@SerializedName("new")
	private Object jsonMemberNew;

	@SerializedName("total")
	private int total;

	public void setJsonMemberNew(Object jsonMemberNew){
		this.jsonMemberNew = jsonMemberNew;
	}

	public Object getJsonMemberNew(){
		return jsonMemberNew;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	@Override
 	public String toString(){
		return 
			"Deaths{" + 
			"new = '" + jsonMemberNew + '\'' + 
			",total = '" + total + '\'' + 
			"}";
		}
}