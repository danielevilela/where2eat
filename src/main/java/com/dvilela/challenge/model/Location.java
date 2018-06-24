package com.dvilela.challenge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	@GeneratedValue
	private int id;
	private int valueX;
	private int valueY;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValueX() {
		return valueX;
	}
	public void setValueX(int valueX) {
		this.valueX = valueX;
	}
	public int getValueY() {
		return valueY;
	}
	public void setValueY(int valueY) {
		this.valueY = valueY;
	}
	
	
}
