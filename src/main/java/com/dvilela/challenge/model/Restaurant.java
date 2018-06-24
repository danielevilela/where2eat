package com.dvilela.challenge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.*;

//@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int pos_id;
	//private Location pos_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPos_id() {
		return pos_id;
	}
	public void setPos_id(int pos_id) {
		this.pos_id = pos_id;
	}
	
	
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pos_id")
	public Location getLocation() {
		return pos_id;
	}
	public void setLocation(Location location) {
		this.pos_id = location;
	}*/

	
}
