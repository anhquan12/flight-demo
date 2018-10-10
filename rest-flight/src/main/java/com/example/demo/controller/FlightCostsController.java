package com.example.demo.controller;

import com.example.demo.entity.FlightCosts;
import com.example.demo.service.FlightCostsService;

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
@CrossOrigin(origins = "*")
@RequestMapping(value = "/flightCosts", produces = "application/hal+json")
public class FlightCostsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightCostsController.class);

	private static final String NOT_FOUND ="FlightCosts not found";

	@Autowired
	private FlightCostsService flightCostsService;

	@RequestMapping(value = "/",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<FlightCosts> findAll() {
		List<FlightCosts> list = flightCostsService.findAll();
		return list;
	}


	@GetMapping("{flightNumber}")
	public FlightCosts get(@PathVariable("flightNumber") Integer flightNumber) {
		final FlightCosts flightCosts = flightCostsService.getOne(flightNumber);
		LOGGER.info("FlightCosts found : {}", flightCosts);
		return flightCosts;
	}

	@PostMapping(consumes = "application/json")
	public FlightCosts create(@RequestBody FlightCosts flightCosts) {
		LOGGER.info("FlightCosts creation request : {}", flightCosts);
		if (flightCostsService.exist(flightCosts)) {
			LOGGER.info("FlightCosts already exist ! : {}", flightCosts);
			return null;
		} else {
			final FlightCosts created = flightCostsService.create(flightCosts);
			LOGGER.info("Created flightCosts {}", created);
			return created;
		}
	}

	@PutMapping(consumes = "application/json")
	public FlightCosts update(@RequestBody FlightCosts flightCosts) {
		return flightCostsService.update(flightCosts);
	}

	@DeleteMapping("{flightNumber}")
	public void delete(@PathVariable("flightNumber") Integer flightNumber) {
		LOGGER.info("FlightCosts deletion request : {}", resolveIdForLogger(flightNumber));
		if (flightCostsService.delete(flightNumber)) {
			LOGGER.info("FlightCosts succesfully deleted");
		} else {
			LOGGER.info(NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer flightNumber) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(flightNumber));
		return ids.toString();
	}

}


