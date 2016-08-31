package com.blinkserver.bean;

import java.io.Serializable;


/**
 * The persistent class for the book database table.
 * 书表
 */
public class BookHS implements Serializable {
	private static final long serialVersionUID = 1L;
	private int bkId;
	private String bkImg;
	private String bkName;
	private String bkShare;
	private String bkUnderstanding;
	private int u_id;

	public BookHS() {
	}

	public BookHS(int bkId, String bkImg, String bkName, String bkShare, String bkUnderstanding, int u_id) {
		this.bkId = bkId;
		this.bkImg = bkImg;
		this.bkName = bkName;
		this.bkShare = bkShare;
		this.bkUnderstanding = bkUnderstanding;
		this.u_id = u_id;
	}

	@Override
	public String toString() {
		return "BookHS{" +
				"bkId=" + bkId +
				", bkImg='" + bkImg + '\'' +
				", bkName='" + bkName + '\'' +
				", bkShare='" + bkShare + '\'' +
				", bkUnderstanding='" + bkUnderstanding + '\'' +
				", u_id=" + u_id +
				'}';
	}

	public int getBkId() {
		return this.bkId;
	}

	public void setBkId(int bkId) {
		this.bkId = bkId;
	}

	public String getBkImg() {
		return this.bkImg;
	}

	public void setBkImg(String bkImg) {
		this.bkImg = bkImg;
	}

	public String getBkName() {
		return this.bkName;
	}

	public void setBkName(String bkName) {
		this.bkName = bkName;
	}

	public String getBkShare() {
		return this.bkShare;
	}

	public void setBkShare(String bkShare) {
		this.bkShare = bkShare;
	}

	public String getBkUnderstanding() {
		return this.bkUnderstanding;
	}

	public void setBkUnderstanding(String bkUnderstanding) {
		this.bkUnderstanding = bkUnderstanding;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	

}