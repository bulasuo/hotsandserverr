package com.blinkserver.bean;

import java.io.Serializable;


/**
 * The persistent class for the mv database table.
 * MV收藏表
 */
public class MVHS implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int mvId;
	private String mvImg;
	private String mvName;
	private String mvShare;
	private String mvUnderstanding;
	private int u_id;

	public MVHS() {
	}

	public MVHS(int mvId, String mvImg, String mvName, String mvShare, String mvUnderstanding, int u_id) {
		this.mvId = mvId;
		this.mvImg = mvImg;
		this.mvName = mvName;
		this.mvShare = mvShare;
		this.mvUnderstanding = mvUnderstanding;
		this.u_id = u_id;
	}

	@Override
	public String toString() {
		return "MVHS{" +
				"mvId=" + mvId +
				", mvImg='" + mvImg + '\'' +
				", mvName='" + mvName + '\'' +
				", mvShare='" + mvShare + '\'' +
				", mvUnderstanding='" + mvUnderstanding + '\'' +
				", u_id=" + u_id +
				'}';
	}

	public int getMvId() {
		return this.mvId;
	}

	public void setMvId(int mvId) {
		this.mvId = mvId;
	}

	public String getMvImg() {
		return this.mvImg;
	}

	public void setMvImg(String mvImg) {
		this.mvImg = mvImg;
	}

	public String getMvName() {
		return this.mvName;
	}

	public void setMvName(String mvName) {
		this.mvName = mvName;
	}

	public String getMvShare() {
		return this.mvShare;
	}

	public void setMvShare(String mvShare) {
		this.mvShare = mvShare;
	}

	public String getMvUnderstanding() {
		return this.mvUnderstanding;
	}

	public void setMvUnderstanding(String mvUnderstanding) {
		this.mvUnderstanding = mvUnderstanding;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	

}