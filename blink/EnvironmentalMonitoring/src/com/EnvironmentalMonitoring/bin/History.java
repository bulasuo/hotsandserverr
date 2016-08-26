package com.EnvironmentalMonitoring.bin;

import java.io.Serializable;
import java.util.ArrayList;

public class History extends ArrayList<History> implements Serializable {
	private int id,value,time,class_id;
	private String name;
	
	public History(int id, int value, int time, int class_id, String name) {
		this.id = id;
		this.value = value;
		this.time = time;
		this.class_id = class_id;
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return "History [id=" + id + ", value=" + value + ", time=" + time
				+ ", class_id=" + class_id + ", name=" + name + "]";
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
