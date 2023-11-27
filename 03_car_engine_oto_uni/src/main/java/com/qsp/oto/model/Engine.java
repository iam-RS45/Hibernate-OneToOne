package com.qsp.oto.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Engine {
	@Id
	private int id;
	private double cc;
	private byte no_of_cy;

	public Engine() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCc() {
		return cc;
	}

	public void setCc(double cc) {
		this.cc = cc;
	}

	public byte getNo_of_cy() {
		return no_of_cy;
	}

	public void setNo_of_cy(byte no_of_cy) {
		this.no_of_cy = no_of_cy;
	}
	
}
