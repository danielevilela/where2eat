package com.dvilela.challenge.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dvilela.challenge.model.Distance;
import com.dvilela.challenge.model.Location;
import com.dvilela.challenge.model.Restaurant;
import com.dvilela.challenge.repository.Locations;
import com.dvilela.challenge.util.Util;

@Controller
public class ChallengeController {

	 private static final Logger logger = LoggerFactory.getLogger(ChallengeController.class);
	
	@Autowired
	private Locations locations;
	
	
	
	@GetMapping("/app")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("location", new Location());
		return modelAndView;
	}
	
	@PostMapping("/init")
	public ModelAndView init(Location userLocation) {
		System.out.println(userLocation.getValueX());
		Util util = new Util();
		List<Location> allLocations =  util.seedLocation();
		List<Restaurant> restaurants = util.seedRestaurant(allLocations);
		List<Distance> distances = util.calculate(userLocation,allLocations,restaurants);
		
		for(Distance d : distances) {
			logger.info("Restaurante"+ d.getId_restaurant()+" Nome "+restaurants.get(d.getId_restaurant()).getName());
		}
		ModelAndView modelAndView = new ModelAndView("ListRestaurants");
		modelAndView.addObject("restaurants", restaurants);
		return modelAndView;
	}
	
	@GetMapping("/restaurants")
	public ModelAndView listRestaurants() {
		ModelAndView modelAndView = new ModelAndView("ListRestaurants");
		modelAndView.addObject("locations", locations.findAll());
		return modelAndView;
	}
	
	
	
}
