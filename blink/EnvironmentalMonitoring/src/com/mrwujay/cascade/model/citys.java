package com.mrwujay.cascade.model;

import java.io.Serializable;
import java.util.ArrayList;





public class citys extends ArrayList<citys> implements Serializable {
	
	private String cityName="";
	private String suggest_0="";
	private String title_0="";
	private String picUrl_0="";
	
	private String title_1="";
	private String picUrl_1="";
	
	private String title_2="";
	private String picUrl_2="";
	
	
	
	@Override
	public String toString() {
		return "citys [cityName=" + cityName + ", suggest_0=" + suggest_0
				+ ", title_0=" + title_0 + ", picUrl_0=" + picUrl_0
				+ ", title_1=" + title_1 + ", picUrl_1=" + picUrl_1
				+ ", title_2=" + title_2 + ", picUrl_2=" + picUrl_2 + "]";
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getSuggest_0() {
		return suggest_0;
	}
	public void setSuggest_0(String suggest_0) {
		this.suggest_0 = suggest_0;
	}
	public String getTitle_0() {
		return title_0;
	}
	public void setTitle_0(String title_0) {
		this.title_0 = title_0;
	}
	public String getPicUrl_0() {
		return picUrl_0;
	}
	public void setPicUrl_0(String picUrl_0) {
		this.picUrl_0 = picUrl_0;
	}
	public String getTitle_1() {
		return title_1;
	}
	public void setTitle_1(String title_1) {
		this.title_1 = title_1;
	}
	public String getPicUrl_1() {
		return picUrl_1;
	}
	public void setPicUrl_1(String picUrl_1) {
		this.picUrl_1 = picUrl_1;
	}
	public String getTitle_2() {
		return title_2;
	}
	public void setTitle_2(String title_2) {
		this.title_2 = title_2;
	}
	public String getPicUrl_2() {
		return picUrl_2;
	}
	public void setPicUrl_2(String picUrl_2) {
		this.picUrl_2 = picUrl_2;
	}

	

	

}
