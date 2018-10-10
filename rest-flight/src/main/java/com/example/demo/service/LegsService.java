/*
 * Created on 2018-10-10 ( Date ISO 2018-10-10 - Time 14:03:17 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.example.demo.service;

import com.example.demo.entity.Legs;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LegsService {

	Legs getOne(Integer legId);

	List<Legs> findAll();

	Page<Legs> findAll(Pageable pageable);

	Boolean delete(Integer legId);

	Legs create(Legs legs);

	Legs update(Legs legs);

	Boolean exist(Legs legs);

}

