package com.dvilela.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvilela.challenge.model.Restaurant;

public interface Restaurants extends JpaRepository<Restaurant,Long> {

}
