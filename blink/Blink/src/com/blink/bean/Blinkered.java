package com.blink.bean;

import java.io.Serializable;


/**
 * The persistent class for the blinkered database table.
 * 
 */
public class Blinkered implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private int bkedId;
	private int bked_blinkerId;
	private int bked_blinkeredId;
	private User blinkedUser;

	public Blinkered() {
	}

	public Blinkered(int bkedId, int bked_blinkerId, int bked_blinkeredId, User blinkedUser) {
		this.bkedId = bkedId;
		this.bked_blinkerId = bked_blinkerId;
		this.bked_blinkeredId = bked_blinkeredId;
		this.blinkedUser = blinkedUser;
	}

	public int getBkedId() {
		return this.bkedId;
	}

	public void setBkedId(int bkedId) {
		this.bkedId = bkedId;
	}

	public int getBked_blinkerId() {
		return bked_blinkerId;
	}

	public void setBked_blinkerId(int bked_blinkerId) {
		this.bked_blinkerId = bked_blinkerId;
	}

	public int getBked_blinkeredId() {
		return bked_blinkeredId;
	}

	public void setBked_blinkeredId(int bked_blinkeredId) {
		this.bked_blinkeredId = bked_blinkeredId;
	}

	public User getBlinkedUser() {
		return blinkedUser;
	}

	public void setBlinkedUser(User blinkedUser) {
		this.blinkedUser = blinkedUser;
	}


	

}