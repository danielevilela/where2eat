package com.dvilela.challenge.util;

import java.util.ArrayList;
import java.util.List;

import com.dvilela.challenge.model.Location;

public class Util {

	public int distanceCalculate(int x1,int y1, int x2, int y2) {		
		int manhattanDistance = Math.abs(x1-x2) + Math.abs(y1-y2);
		return manhattanDistance;
	}

	public void calculate(Location userLocation, List<Location> allLocations) {
		List<Integer> distances = new ArrayList<Integer>();
		
		int distance = 0;
		for(Location l : allLocations) {
			distance = distanceCalculate(userLocation.getValueX(),userLocation.getValueY(),l.getValueX(),l.getValueY());
			distances.add(distance);
		}
		
	}

	public List<Location> seedLocation() {
		List<Location> seed = new ArrayList<Location>();
		Location l = new Location();
		for(int i = 0; i < 30; i++) {
			l.setId(i);
			l.setValueX(i);
			l.setValueY(i+1);
			seed.add(l);
		}
		return seed;
	}
}
