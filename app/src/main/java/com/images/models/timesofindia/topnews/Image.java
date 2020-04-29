package com.images.models.timesofindia.topnews;


import com.google.gson.annotations.SerializedName;

public class Image{

	@SerializedName("PhotoCaption")
	private String photoCaption;

	@SerializedName("Thumb")
	private String thumb;

	@SerializedName("Photo")
	private String photo;

	public void setPhotoCaption(String photoCaption){
		this.photoCaption = photoCaption;
	}

	public String getPhotoCaption(){
		return photoCaption;
	}

	public void setThumb(String thumb){
		this.thumb = thumb;
	}

	public String getThumb(){
		return thumb;
	}

	public void setPhoto(String photo){
		this.photo = photo;
	}

	public String getPhoto(){
		return photo;
	}

	@Override
 	public String toString(){
		return 
			"Image{" + 
			"photoCaption = '" + photoCaption + '\'' + 
			",thumb = '" + thumb + '\'' + 
			",photo = '" + photo + '\'' + 
			"}";
		}
}