/*
 * Created on 2018-10-10 ( Date ISO 2018-10-10 - Time 14:03:17 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.example.demo.controller;

import com.example.demo.entity.Passengers;
import com.example.demo.service.PassengersService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@CrossOrigin(origins = "localhost:")
@RequestMapping(value = "/passengers", produces = "application/hal+json")
public class PassengersController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PassengersController.class);

	private static final String NOT_FOUND ="Passengers not found";

	@Autowired
	private PassengersService passengersService;

	@RequestMapping(value = "/",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Passengers> findAll() {
		List<Passengers> list = passengersService.findAll();
		return list;
	}


	@GetMapping("{passengerId}")
	public Passengers get(@PathVariable("passengerId") Integer passengerId) {
		final Passengers passengers = passengersService.getOne(passengerId);
		LOGGER.info("Passengers found : {}", passengers);
		return passengers;
	}

	@PostMapping(consumes = "application/json")
	public Passengers create(@RequestBody Passengers passengers) {
		LOGGER.info("Passengers creation request : {}", passengers);
		if (passengersService.exist(passengers)) {
			LOGGER.info("Passengers already exist ! : {}", passengers);
			return null;
		} else {
			final Passengers created = passengersService.create(passengers);
			LOGGER.info("Created passengers {}", created);
			return created;
		}
	}

	@PutMapping(consumes = "application/json")
	public Passengers update(@RequestBody Passengers passengers) {
		return passengersService.update(passengers);
	}

	@DeleteMapping("{passengerId}")
	public void delete(@PathVariable("passengerId") Integer passengerId) {
		LOGGER.info("Passengers deletion request : {}", resolveIdForLogger(passengerId));
		if (passengersService.delete(passengerId)) {
			LOGGER.info("Passengers succesfully deleted");
		} else {
			LOGGER.info(NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer passengerId) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(passengerId));
		return ids.toString();
	}

}

