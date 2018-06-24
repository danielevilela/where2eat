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
import com.dvilela.challenge.repository.Locations;
import com.dvilela.challenge.repository.Restaurants;


public class Util {
	
	 private String googleKey = "AIzaSyBa8mPI3jgw6L5YPfhkXTyaZmzsTJEwwWc";
	 private static final Logger logger = LoggerFactory.getLogger(Util.class);
	 private Restaurants iRestaurants;
	 private Locations iLocations;


	public double distanceCalculate(double x1,double y1, double x2, double y2) {		
		double manhattanDistance = Math.abs(x1-x2) + Math.abs(y1-y2);
		return manhattanDistance;
	}

	public List<Distance> calculate(Location userLocation, List<Location> allLocations, List<Restaurant> restaurants) {
		List<Distance> distances = new ArrayList<Distance>();
		double distance = 0;
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
		double x = -23.582423313056886;
		double y = -46.703185879907224;
		for(int i = 0; i < 30; i++) {
			Location l = new Location();
			//l.setId(i);
			l.setValueX(x+(Math.random()*10));
			l.setValueY(y+(Math.random()*10));
			logger.info(l.getValueX() + " "+ l.getValueY());
			//this.iLocations.save(l);
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
			//this.iRestaurants.save(r); 
			seed.add(r);
		}
		return seed;
	}
	
}
