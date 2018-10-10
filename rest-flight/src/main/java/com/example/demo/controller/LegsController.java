package com.example.demo.controller;

import com.example.demo.entity.Legs;
import com.example.demo.service.LegsService;

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
@RequestMapping(value = "/legs", produces = "application/hal+json")
public class LegsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LegsController.class);

	private static final String NOT_FOUND ="Legs not found";

	@Autowired
	private LegsService legsService;

	@RequestMapping(value = "/",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Legs> findAll() {
		List<Legs> list = legsService.findAll();
		return list;
	}


	@GetMapping("{legId}")
	public Legs get(@PathVariable("legId") Integer legId) {
		final Legs legs = legsService.getOne(legId);
		LOGGER.info("Legs found : {}", legs);
		return legs;
	}

	@PostMapping(consumes = "application/json")
	public Legs create(@RequestBody Legs legs) {
		LOGGER.info("Legs creation request : {}", legs);
		if (legsService.exist(legs)) {
			LOGGER.info("Legs already exist ! : {}", legs);
			return null;
		} else {
			final Legs created = legsService.create(legs);
			LOGGER.info("Created legs {}", created);
			return created;
		}
	}

	@PutMapping(consumes = "application/json")
	public Legs update(@RequestBody Legs legs) {
		return legsService.update(legs);
	}

	@DeleteMapping("{legId}")
	public void delete(@PathVariable("legId") Integer legId) {
		LOGGER.info("Legs deletion request : {}", resolveIdForLogger(legId));
		if (legsService.delete(legId)) {
			LOGGER.info("Legs succesfully deleted");
		} else {
			LOGGER.info(NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer legId) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(legId));
		return ids.toString();
	}

}


