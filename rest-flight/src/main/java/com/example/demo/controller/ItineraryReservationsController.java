package com.example.demo.controller;

import com.example.demo.entity.ItineraryReservations;
import com.example.demo.service.ItineraryReservationsService;

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
@RequestMapping(value = "/itineraryReservations", produces = "application/hal+json")
public class ItineraryReservationsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItineraryReservationsController.class);

	private static final String NOT_FOUND ="ItineraryReservations not found";

	@Autowired
	private ItineraryReservationsService itineraryReservationsService;

	@RequestMapping(value = "/",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ItineraryReservations> findAll() {
		List<ItineraryReservations> list = itineraryReservationsService.findAll();
		return list;
	}


	@GetMapping("{reservationId}")
	public ItineraryReservations get(@PathVariable("reservationId") Integer reservationId) {
		final ItineraryReservations itineraryReservations = itineraryReservationsService.getOne(reservationId);
		LOGGER.info("ItineraryReservations found : {}", itineraryReservations);
		return itineraryReservations;
	}

	@PostMapping(consumes = "application/json")
	public ItineraryReservations create(@RequestBody ItineraryReservations itineraryReservations) {
		LOGGER.info("ItineraryReservations creation request : {}", itineraryReservations);
		if (itineraryReservationsService.exist(itineraryReservations)) {
			LOGGER.info("ItineraryReservations already exist ! : {}", itineraryReservations);
			return null;
		} else {
			final ItineraryReservations created = itineraryReservationsService.create(itineraryReservations);
			LOGGER.info("Created itineraryReservations {}", created);
			return created;
		}
	}

	@PutMapping(consumes = "application/json")
	public ItineraryReservations update(@RequestBody ItineraryReservations itineraryReservations) {
		return itineraryReservationsService.update(itineraryReservations);
	}

	@DeleteMapping("{reservationId}")
	public void delete(@PathVariable("reservationId") Integer reservationId) {
		LOGGER.info("ItineraryReservations deletion request : {}", resolveIdForLogger(reservationId));
		if (itineraryReservationsService.delete(reservationId)) {
			LOGGER.info("ItineraryReservations succesfully deleted");
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


