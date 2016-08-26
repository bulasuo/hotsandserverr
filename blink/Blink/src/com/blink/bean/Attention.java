package com.blink.bean;

import java.io.Serializable;


/**
 * The persistent class for the attention database table.
 * 
 */
public class Attention implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int atnId;
	private int atn_atnerId;
	private int atn_atneredId;
	private User atneredUser;

	public Attention() {
	}

	public Attention(int atnId, int atn_atnerId, int atn_atneredId, User atneredUser) {
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

	public User getAtneredUser() {
		return atneredUser;
	}

	public void setAtneredUser(User atneredUser) {
		this.atneredUser = atneredUser;
	}



}