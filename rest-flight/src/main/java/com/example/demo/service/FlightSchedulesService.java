/*
 * Created on 2018-10-10 ( Date ISO 2018-10-10 - Time 14:03:17 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.example.demo.service;

import com.example.demo.entity.FlightSchedules;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FlightSchedulesService {

	FlightSchedules getOne(Integer flightNumber);

	List<FlightSchedules> findAll();

	Page<FlightSchedules> findAll(Pageable pageable);

	Boolean delete(Integer flightNumber);

	FlightSchedules create(FlightSchedules flightSchedules);

	FlightSchedules update(FlightSchedules flightSchedules);

	Boolean exist(FlightSchedules flightSchedules);

}

