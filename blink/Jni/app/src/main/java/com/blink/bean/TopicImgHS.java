package com.blink.bean;

import java.io.Serializable;


/**
 * The persistent class for the topicimg database table.
 * 话题配图表
 */
public class TopicImgHS implements Serializable {
	private static final long serialVersionUID = 1L;

	private int tImg_id;
	private String tImg_img;
	private int tc_id;

	public TopicImgHS() {
	}

	public TopicImgHS(int tImg_id, String tImg_img, int tc_id) {
		this.tImg_id = tImg_id;
		this.tImg_img = tImg_img;
		this.tc_id = tc_id;
	}

	public int getTImg_id() {
		return this.tImg_id;
	}

	public void setTImg_id(int tImg_id) {
		this.tImg_id = tImg_id;
	}

	public String getTImg_img() {
		return this.tImg_img;
	}

	public void setTImg_img(String tImg_img) {
		this.tImg_img = tImg_img;
	}

	public int getTc_id() {
		return tc_id;
	}

	public void setTc_id(int tc_id) {
		this.tc_id = tc_id;
	}
	

}