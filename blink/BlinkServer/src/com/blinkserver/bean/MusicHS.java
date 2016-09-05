package com.blinkserver.bean;

import java.io.Serializable;


/**
 * The persistent class for the music database table.
 * 音乐收藏表
 */
public class MusicHS implements Serializable {
	private static final long serialVersionUID = 1L;

	private int msId;
	private String msImg;
	private String msName;
	private String msShare;
	private String msUnderstanding;
	private int u_id;

	public MusicHS() {
	}

	@Override
	public String toString() {
		return "MusicHS{" +
				"msId=" + msId +
				", msImg='" + msImg + '\'' +
				", msName='" + msName + '\'' +
				", msShare='" + msShare + '\'' +
				", msUnderstanding='" + msUnderstanding + '\'' +
				", u_id=" + u_id +
				'}';
	}

	public MusicHS(int msId, String msImg, String msName, String msShare, String msUnderstanding, int u_id) {
		this.msId = msId;
		this.msImg = msImg;
		this.msName = msName;
		this.msShare = msShare;
		this.msUnderstanding = msUnderstanding;
		this.u_id = u_id;
	}

	public int getMsId() {
		return this.msId;
	}

	public void setMsId(int msId) {
		this.msId = msId;
	}

	public String getMsImg() {
		return this.msImg;
	}

	public void setMsImg(String msImg) {
		this.msImg = msImg;
	}

	public String getMsName() {
		return this.msName;
	}

	public void setMsName(String msName) {
		this.msName = msName;
	}

	public String getMsShare() {
		return this.msShare;
	}

	public void setMsShare(String msShare) {
		this.msShare = msShare;
	}

	public String getMsUnderstanding() {
		return this.msUnderstanding;
	}

	public void setMsUnderstanding(String msUnderstanding) {
		this.msUnderstanding = msUnderstanding;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	

}