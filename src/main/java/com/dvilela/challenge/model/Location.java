package com.dvilela.challenge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Location implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	private double valueX;
	private double valueY;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValueX() {
		return valueX;
	}
	public void setValueX(double valueX) {
		this.valueX = valueX;
	}
	public double getValueY() {
		return valueY;
	}
	public void setValueY(double valueY) {
		this.valueY = valueY;
	}
	
	
}
