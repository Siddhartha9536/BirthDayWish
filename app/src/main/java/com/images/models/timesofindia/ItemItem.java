package com.images.models.timesofindia;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ItemItem implements Serializable {

	@SerializedName("template")
	private String template;

	@SerializedName("subsections")
	private String subsections;

	@SerializedName("name")
	private String name;

	@SerializedName("sectionurl")
	private String sectionurl;

	@SerializedName("Icon")
	private String icon;

	@SerializedName("ID")
	private String iD;

	@SerializedName("defaultname")
	private String defaultname;

	@SerializedName("defaulturl")
	private String defaulturl;

	public void setTemplate(String template){
		this.template = template;
	}

	public String getTemplate(){
		return template;
	}

	public void setSubsections(String subsections){
		this.subsections = subsections;
	}

	public String getSubsections(){
		return subsections;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSectionurl(String sectionurl){
		this.sectionurl = sectionurl;
	}

	public String getSectionurl(){
		return sectionurl;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setID(String iD){
		this.iD = iD;
	}

	public String getID(){
		return iD;
	}

	public void setDefaultname(String defaultname){
		this.defaultname = defaultname;
	}

	public String getDefaultname(){
		return defaultname;
	}

	public void setDefaulturl(String defaulturl){
		this.defaulturl = defaulturl;
	}

	public String getDefaulturl(){
		return defaulturl;
	}

	@Override
 	public String toString(){
		return 
			"ItemItem{" + 
			"template = '" + template + '\'' + 
			",subsections = '" + subsections + '\'' + 
			",name = '" + name + '\'' + 
			",sectionurl = '" + sectionurl + '\'' + 
			",icon = '" + icon + '\'' + 
			",iD = '" + iD + '\'' + 
			",defaultname = '" + defaultname + '\'' + 
			",defaulturl = '" + defaulturl + '\'' + 
			"}";
		}
}