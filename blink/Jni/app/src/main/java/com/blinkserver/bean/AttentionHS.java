package com.blinkserver.bean;

import java.io.Serializable;


/**
 * The persistent class for the attention database table.
 * 关注 动作表
 */
public class AttentionHS implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int atnId;
	private int atn_atnerId;
	private int atn_atneredId;
	private UserHS atneredUser;

	public AttentionHS() {
	}

	public AttentionHS(int atnId, int atn_atnerId, int atn_atneredId, UserHS atneredUser) {
		this.atnId = atnId;
		this.atn_atnerId = atn_atnerId;
		this.atn_atneredId = atn_atneredId;
		this.atneredUser = atneredUser;
	}

	public int getAtnId() {
		return this.atnId;
	}

	public void setAtnId(int atnId) {
		this.atnId = atnId;
	}

	public int getAtn_atnerId() {
		return atn_atnerId;
	}

	public void setAtn_atnerId(int atn_atnerId) {
		this.atn_atnerId = atn_atnerId;
	}

	public int getAtn_atneredId() {
		return atn_atneredId;
	}

	public void setAtn_atneredId(int atn_atneredId) {
		this.atn_atneredId = atn_atneredId;
	}

	public UserHS getAtneredUser() {
		return atneredUser;
	}

	public void setAtneredUser(UserHS atneredUser) {
		this.atneredUser = atneredUser;
	}



}