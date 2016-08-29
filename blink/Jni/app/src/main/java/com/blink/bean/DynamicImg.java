package com.blink.bean;

import java.io.Serializable;


/**
 * The persistent class for the dynamicimg database table.
 * 动态配图表
 */
public class DynamicImg implements Serializable {
	private static final long serialVersionUID = 1L;

	private int dImg_id;
	private String dImg_img;
	private int dnc_id;

	public DynamicImg() {
	}

	public DynamicImg(int dImg_id, String dImg_img, int dnc_id) {
		this.dImg_id = dImg_id;
		this.dImg_img = dImg_img;
		this.dnc_id = dnc_id;
	}

	@Override
	public String toString() {
		return "DynamicImg{" +
				"dImg_id=" + dImg_id +
				", dImg_img='" + dImg_img + '\'' +
				", dnc_id=" + dnc_id +
				'}';
	}

	public int getDImg_id() {
		return this.dImg_id;
	}

	public void setDImg_id(int dImg_id) {
		this.dImg_id = dImg_id;
	}

	public String getDImg_img() {
		return this.dImg_img;
	}

	public void setDImg_img(String dImg_img) {
		this.dImg_img = dImg_img;
	}

	public int getDnc_id() {
		return dnc_id;
	}

	public void setDnc_id(int dnc_id) {
		this.dnc_id = dnc_id;
	}

	

}