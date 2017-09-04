package com.cgm.twitter.data;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class User implements Serializable {
	
	private String name;
	private boolean isOnline;
	private Date lasOnline;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public Date getLasOnline() {
		return lasOnline;
	}
	public void setLasOnline(Date lasOnline) {
		this.lasOnline = lasOnline;
	}

}
