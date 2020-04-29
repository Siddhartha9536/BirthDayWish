package com.images.models.timesofindia.topnews;


import com.google.gson.annotations.SerializedName;

public class Pagination{

	@SerializedName("PerPage")
	private String perPage;

	@SerializedName("WebURL")
	private String webURL;

	@SerializedName("TotalPages")
	private String totalPages;

	@SerializedName("PageNo")
	private String pageNo;

	public void setPerPage(String perPage){
		this.perPage = perPage;
	}

	public String getPerPage(){
		return perPage;
	}

	public void setWebURL(String webURL){
		this.webURL = webURL;
	}

	public String getWebURL(){
		return webURL;
	}

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
			"perPage = '" + perPage + '\'' + 
			",webURL = '" + webURL + '\'' + 
			",totalPages = '" + totalPages + '\'' + 
			",pageNo = '" + pageNo + '\'' + 
			"}";
		}
}