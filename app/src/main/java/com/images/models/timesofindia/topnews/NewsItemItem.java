package com.images.models.timesofindia.topnews;


import com.google.gson.annotations.SerializedName;

public class NewsItemItem{

	@SerializedName("HeadLine")
	private String headLine;

	@SerializedName("CommentCountUrl")
	private String commentCountUrl;

	@SerializedName("Agency")
	private String agency;

	@SerializedName("Keywords")
	private String keywords;

	@SerializedName("ByLine")
	private String byLine;

	@SerializedName("CommentFeedUrl")
	private String commentFeedUrl;

	@SerializedName("WebURL")
	private String webURL;

	@SerializedName("Image")
	private Image image;

	@SerializedName("Caption")
	private String caption;

	@SerializedName("DateLine")
	private String dateLine;

	@SerializedName("Related")
	private String related;

	@SerializedName("NewsItemId")
	private String newsItemId;

	@SerializedName("Story")
	private String story;

	public void setHeadLine(String headLine){
		this.headLine = headLine;
	}

	public String getHeadLine(){
		return headLine;
	}

	public void setCommentCountUrl(String commentCountUrl){
		this.commentCountUrl = commentCountUrl;
	}

	public String getCommentCountUrl(){
		return commentCountUrl;
	}

	public void setAgency(String agency){
		this.agency = agency;
	}

	public String getAgency(){
		return agency;
	}

	public void setKeywords(String keywords){
		this.keywords = keywords;
	}

	public String getKeywords(){
		return keywords;
	}

	public void setByLine(String byLine){
		this.byLine = byLine;
	}

	public String getByLine(){
		return byLine;
	}

	public void setCommentFeedUrl(String commentFeedUrl){
		this.commentFeedUrl = commentFeedUrl;
	}

	public String getCommentFeedUrl(){
		return commentFeedUrl;
	}

	public void setWebURL(String webURL){
		this.webURL = webURL;
	}

	public String getWebURL(){
		return webURL;
	}

	public void setImage(Image image){
		this.image = image;
	}

	public Image getImage(){
		return image;
	}

	public void setCaption(String caption){
		this.caption = caption;
	}

	public String getCaption(){
		return caption;
	}

	public void setDateLine(String dateLine){
		this.dateLine = dateLine;
	}

	public String getDateLine(){
		return dateLine;
	}

	public void setRelated(String related){
		this.related = related;
	}

	public String getRelated(){
		return related;
	}

	public void setNewsItemId(String newsItemId){
		this.newsItemId = newsItemId;
	}

	public String getNewsItemId(){
		return newsItemId;
	}

	public void setStory(String story){
		this.story = story;
	}

	public String getStory(){
		return story;
	}

	@Override
 	public String toString(){
		return 
			"NewsItemItem{" + 
			"headLine = '" + headLine + '\'' + 
			",commentCountUrl = '" + commentCountUrl + '\'' + 
			",agency = '" + agency + '\'' + 
			",keywords = '" + keywords + '\'' + 
			",byLine = '" + byLine + '\'' + 
			",commentFeedUrl = '" + commentFeedUrl + '\'' + 
			",webURL = '" + webURL + '\'' + 
			",image = '" + image + '\'' + 
			",caption = '" + caption + '\'' + 
			",dateLine = '" + dateLine + '\'' + 
			",related = '" + related + '\'' + 
			",newsItemId = '" + newsItemId + '\'' + 
			",story = '" + story + '\'' + 
			"}";
		}
}