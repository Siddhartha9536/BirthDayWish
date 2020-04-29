package com.images.models.indiastates;


import com.google.gson.annotations.SerializedName;

public class StateRes{

	@SerializedName("response")
	private Response1 response;

	@SerializedName("status")
	private String status;

	@SerializedName("statusCode")
	private String statusCode;

	public void setResponse(Response1 response1){
		this.response = response1;
	}

	public Response1 getResponse(){
		return response;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setStatusCode(String statusCode){
		this.statusCode = statusCode;
	}

	public String getStatusCode(){
		return statusCode;
	}

	@Override
 	public String toString(){
		return 
			"StateRes{" + 
			"response = '" + response + '\'' + 
			",status = '" + status + '\'' + 
			",statusCode = '" + statusCode + '\'' + 
			"}";
		}
}