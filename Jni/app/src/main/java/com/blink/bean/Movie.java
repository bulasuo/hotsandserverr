package com.blink.bean;

import java.io.Serializable;


/**
 * The persistent class for the movie database table.
 * 电影收藏表
 */
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	private int moId;
	private String moImg;
	private String moName;
	private String moShare;
	private String moUnderstanding;
	private int u_id;

	public Movie() {
	}

	public Movie(int moId, String moImg, String moName, String moShare, String moUnderstanding, int u_id) {
		this.moId = moId;
		this.moImg = moImg;
		this.moName = moName;
		this.moShare = moShare;
		this.moUnderstanding = moUnderstanding;
		this.u_id = u_id;
	}

	public int getMoId() {
		return this.moId;
	}

	public void setMoId(int moId) {
		this.moId = moId;
	}

	public String getMoImg() {
		return this.moImg;
	}

	public void setMoImg(String moImg) {
		this.moImg = moImg;
	}

	public String getMoName() {
		return this.moName;
	}

	public void setMoName(String moName) {
		this.moName = moName;
	}

	public String getMoShare() {
		return this.moShare;
	}

	public void setMoShare(String moShare) {
		this.moShare = moShare;
	}

	public String getMoUnderstanding() {
		return this.moUnderstanding;
	}

	public void setMoUnderstanding(String moUnderstanding) {
		this.moUnderstanding = moUnderstanding;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}


}