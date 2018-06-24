package com.dvilela.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvilela.challenge.model.Location;;

public interface Locations extends JpaRepository<Location,Long> {

}
