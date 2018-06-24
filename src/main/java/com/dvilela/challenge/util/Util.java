package com.dvilela.challenge.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dvilela.challenge.model.Distance;
import com.dvilela.challenge.model.Location;
import com.dvilela.challenge.model.Restaurant;


public class Util {
	
	 private String googleKey = "AIzaSyBa8mPI3jgw6L5YPfhkXTyaZmzsTJEwwWc";
	 private static final Logger logger = LoggerFactory.getLogger(Util.class);


	public int distanceCalculate(int x1,int y1, int x2, int y2) {		
		int manhattanDistance = Math.abs(x1-x2) + Math.abs(y1-y2);
		return manhattanDistance;
	}

	public List<Distance> calculate(Location userLocation, List<Location> allLocations, List<Restaurant> restaurants) {
		List<Distance> distances = new ArrayList<Distance>();
		List<JSONObject> entities = new ArrayList<JSONObject>();
		int distance = 0;
		int key = 1;
		for(Restaurant r : restaurants) {
		
				//JSONObject entity = new JSONObject();
				Distance d  = new Distance();
				d.setId(key);
				d.setId_restaurant(r.getId());
				d.setId_position(r.getPos_id());
				distance = distanceCalculate(userLocation.getValueX(),userLocation.getValueY(),allLocations.get(r.getPos_id()).getValueX(),allLocations.get(r.getPos_id()).getValueY());
				d.setDistance(distance);
				distances.add(d);
				//entity.put("options", d);
			
			key++;
		}
		return distances;
		
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
	public List<Restaurant> seedRestaurant(List<Location> location) {
		List<Restaurant> seed = new ArrayList<Restaurant>();
		Location l = new Location();		
		for(int i = 0; i < 30; i++) {
			Restaurant r = new Restaurant();
			r.setId(i);
			r.setName("Restaurant "+i);
			r.setPos_id(location.get(i).getId());
			seed.add(r);
		}
		return seed;
	}
	
}
