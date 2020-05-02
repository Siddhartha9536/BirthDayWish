package com.images.models.photonews;


import com.google.gson.annotations.SerializedName;

public class Pagination{

	@SerializedName("TotalPages")
	private String totalPages;

	@SerializedName("PageNo")
	private String pageNo;

	public void setTotalPages(String totalPages){
		this.totalPages = totalPages;
	}

	public String getTotalPages(){
		return totalPages;
	}

	public void setPageNo(String pageNo){
		this.pageNo = pageNo;
	}

	public String getPageNo(){
		return pageNo;
	}

	@Override
 	public String toString(){
		return 
			"Pagination{" + 
			"totalPages = '" + totalPages + '\'' + 
			",pageNo = '" + pageNo + '\'' + 
			"}";
		}
}