/*
 * Created on 2018-10-10 ( Date ISO 2018-10-10 - Time 14:03:17 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.example.demo.service;

import com.example.demo.entity.Airports;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AirportsService {

	Airports getOne(Integer airportCode);

	List<Airports> findAll();

	Page<Airports> findAll(Pageable pageable);

	Boolean delete(Integer airportCode);

	Airports create(Airports airports);

	Airports update(Airports airports);

	Boolean exist(Airports airports);

}

