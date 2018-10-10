
package com.example.demo.controller;

import com.example.demo.entity.ItineraryLegs;
import com.example.demo.service.ItineraryLegsService;

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
@RequestMapping(value = "/itineraryLegs", produces = "application/hal+json")
public class ItineraryLegsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItineraryLegsController.class);

	private static final String NOT_FOUND ="ItineraryLegs not found";

	@Autowired
	private ItineraryLegsService itineraryLegsService;

	@RequestMapping(value = "/",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ItineraryLegs> findAll() {
		List<ItineraryLegs> list = itineraryLegsService.findAll();
		return list;
	}


	@GetMapping("{reservationId}")
	public ItineraryLegs get(@PathVariable("reservationId") Integer reservationId) {
		final ItineraryLegs itineraryLegs = itineraryLegsService.getOne(reservationId);
		LOGGER.info("ItineraryLegs found : {}", itineraryLegs);
		return itineraryLegs;
	}

	@PostMapping(consumes = "application/json")
	public ItineraryLegs create(@RequestBody ItineraryLegs itineraryLegs) {
		LOGGER.info("ItineraryLegs creation request : {}", itineraryLegs);
		if (itineraryLegsService.exist(itineraryLegs)) {
			LOGGER.info("ItineraryLegs already exist ! : {}", itineraryLegs);
			return null;
		} else {
			final ItineraryLegs created = itineraryLegsService.create(itineraryLegs);
			LOGGER.info("Created itineraryLegs {}", created);
			return created;
		}
	}

	@PutMapping(consumes = "application/json")
	public ItineraryLegs update(@RequestBody ItineraryLegs itineraryLegs) {
		return itineraryLegsService.update(itineraryLegs);
	}

	@DeleteMapping("{reservationId}")
	public void delete(@PathVariable("reservationId") Integer reservationId) {
		LOGGER.info("ItineraryLegs deletion request : {}", resolveIdForLogger(reservationId));
		if (itineraryLegsService.delete(reservationId)) {
			LOGGER.info("ItineraryLegs succesfully deleted");
		} else {
			LOGGER.info(NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer reservationId) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(reservationId));
		return ids.toString();
	}

}


