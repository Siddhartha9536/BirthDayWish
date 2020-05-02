package com.images.models.photonews;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Photores{

	@SerializedName("Pagination")
	private Pagination pagination;

	@SerializedName("NewsItem")
	private List<NewsItemItem> newsItem;

	public void setPagination(Pagination pagination){
		this.pagination = pagination;
	}

	public Pagination getPagination(){
		return pagination;
	}

	public void setNewsItem(List<NewsItemItem> newsItem){
		this.newsItem = newsItem;
	}

	public List<NewsItemItem> getNewsItem(){
		return newsItem;
	}

	@Override
 	public String toString(){
		return 
			"Photores{" + 
			"pagination = '" + pagination + '\'' + 
			",newsItem = '" + newsItem + '\'' + 
			"}";
		}
}