package com.blink.bean;

import java.io.Serializable;


/**
 * The persistent class for the userimg database table.
 * 用户照片墙配图表
 */
public class UserImgHS implements Serializable {
	private static final long serialVersionUID = 1L;

	private int uImg_id;

	private String uImg_img;
	private int u_id;

	public UserImgHS() {
	}

	public UserImgHS(int uImg_id, String uImg_img, int u_id) {
		this.uImg_id = uImg_id;
		this.uImg_img = uImg_img;
		this.u_id = u_id;
	}

	public int getUImg_id() {
		return this.uImg_id;
	}

	public void setUImg_id(int uImg_id) {
		this.uImg_id = uImg_id;
	}

	public String getUImg_img() {
		return this.uImg_img;
	}

	public void setUImg_img(String uImg_img) {
		this.uImg_img = uImg_img;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	

}