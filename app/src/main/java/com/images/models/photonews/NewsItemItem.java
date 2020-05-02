package com.images.models.photonews;

import com.google.gson.annotations.SerializedName;

public class NewsItemItem{

	@SerializedName("HeadLine")
	private String headLine;

	@SerializedName("DateLine")
	private String dateLine;

	@SerializedName("PubDate")
	private String pubDate;

	@SerializedName("SlugLine")
	private String slugLine;

	@SerializedName("Thumb")
	private String thumb;

	@SerializedName("WebUrl")
	private String webUrl;

	@SerializedName("DetailFeed")
	private String detailFeed;

	@SerializedName("Photo")
	private String photo;

	@SerializedName("Slideshowlink")
	private String slideshowlink;

	@SerializedName("NewsItemId")
	private String newsItemId;

	@SerializedName("Caption")
	private String caption;

	public void setHeadLine(String headLine){
		this.headLine = headLine;
	}

	public String getHeadLine(){
		return headLine;
	}

	public void setDateLine(String dateLine){
		this.dateLine = dateLine;
	}

	public String getDateLine(){
		return dateLine;
	}

	public void setPubDate(String pubDate){
		this.pubDate = pubDate;
	}

	public String getPubDate(){
		return pubDate;
	}

	public void setSlugLine(String slugLine){
		this.slugLine = slugLine;
	}

	public String getSlugLine(){
		return slugLine;
	}

	public void setThumb(String thumb){
		this.thumb = thumb;
	}

	public String getThumb(){
		return thumb;
	}

	public void setWebUrl(String webUrl){
		this.webUrl = webUrl;
	}

	public String getWebUrl(){
		return webUrl;
	}

	public void setDetailFeed(String detailFeed){
		this.detailFeed = detailFeed;
	}

	public String getDetailFeed(){
		return detailFeed;
	}

	public void setPhoto(String photo){
		this.photo = photo;
	}

	public String getPhoto(){
		return photo;
	}

	public void setSlideshowlink(String slideshowlink){
		this.slideshowlink = slideshowlink;
	}

	public String getSlideshowlink(){
		return slideshowlink;
	}

	public void setNewsItemId(String newsItemId){
		this.newsItemId = newsItemId;
	}

	public String getNewsItemId(){
		return newsItemId;
	}

	public void setCaption(String caption){
		this.caption = caption;
	}

	public String getCaption(){
		return caption;
	}

	@Override
 	public String toString(){
		return 
			"NewsItemItem{" + 
			"headLine = '" + headLine + '\'' + 
			",dateLine = '" + dateLine + '\'' + 
			",pubDate = '" + pubDate + '\'' + 
			",slugLine = '" + slugLine + '\'' + 
			",thumb = '" + thumb + '\'' + 
			",webUrl = '" + webUrl + '\'' + 
			",detailFeed = '" + detailFeed + '\'' + 
			",photo = '" + photo + '\'' + 
			",slideshowlink = '" + slideshowlink + '\'' + 
			",newsItemId = '" + newsItemId + '\'' + 
			",caption = '" + caption + '\'' + 
			"}";
		}
}