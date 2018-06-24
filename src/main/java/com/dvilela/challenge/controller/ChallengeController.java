package com.dvilela.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dvilela.challenge.model.Location;
import com.dvilela.challenge.repository.Locations;
import com.dvilela.challenge.util.Util;

@Controller
public class ChallengeController {
	
	@Autowired
	private Locations locations;
	
	
	
	@GetMapping("/app")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("location", new Location());
		return modelAndView;
	}
	
	@PostMapping("/init")
	public void init(Location userLocation) {
		System.out.println(userLocation.getValueX());
		Util util = new Util();
		util.calculate(userLocation, util.seedLocation());
		
	}
	
	@GetMapping("/restaurants")
	public ModelAndView listRestaurants() {
		ModelAndView modelAndView = new ModelAndView("ListRestaurants");
		modelAndView.addObject("locations", locations.findAll());
		return modelAndView;
	}
	
	
	
}
