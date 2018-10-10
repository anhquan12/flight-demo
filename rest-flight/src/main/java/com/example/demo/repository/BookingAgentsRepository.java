/*
 * Created on 2018-10-10 ( Date ISO 2018-10-10 - Time 14:03:17 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.example.demo.repository;

import com.example.demo.entity.BookingAgents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Jpa repository for BookingAgents.
 * @author Telosys (http://www.telosys.org/) version 3.0.0
 */
@Repository
public interface BookingAgentsRepository  extends JpaRepository<BookingAgents, Integer> {}