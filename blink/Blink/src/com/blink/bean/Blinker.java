package com.blink.bean;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the blinkers database table.
 * 
 */
public class Blinker implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int bkId;
	private int bk_blinkeredId;
	private int bk_blinkerId;
	private User blinkUser;
	private Timestamp bk_createDate;

	public Blinker() {
	}

	public Blinker(int bkId, int bk_blinkeredId, int bk_blinkerId, User blinkUser, Timestamp bk_createDate) {
		this.bkId = bkId;
		this.bk_blinkeredId = bk_blinkeredId;
		this.bk_blinkerId = bk_blinkerId;
		this.blinkUser = blinkUser;
		this.bk_createDate = bk_createDate;
	}

	public int getBkId() {
		return this.bkId;
	}

	public void setBkId(int bkId) {
		this.bkId = bkId;
	}

	public int getBk_blinkeredId() {
		return bk_blinkeredId;
	}

	public void setBk_blinkeredId(int bk_blinkeredId) {
		this.bk_blinkeredId = bk_blinkeredId;
	}

	public int getBk_blinkerId() {
		return bk_blinkerId;
	}

	public void setBk_blinkerId(int bk_blinkerId) {
		this.bk_blinkerId = bk_blinkerId;
	}

	public User getBlinkUser() {
		return blinkUser;
	}

	public void setBlinkUser(User blinkUser) {
		this.blinkUser = blinkUser;
	}

	public Timestamp getBk_createDate() {
		return bk_createDate;
	}

	public void setBk_createDate(Timestamp bk_createDate) {
		this.bk_createDate = bk_createDate;
	}
	
	

	

}