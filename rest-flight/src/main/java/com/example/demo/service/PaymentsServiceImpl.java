/*
 * Created on 2018-10-10 ( Date ISO 2018-10-10 - Time 14:03:17 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.example.demo.service;


import java.util.List; 

import javax.transaction.Transactional;

import com.example.demo.entity.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PaymentsRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@Transactional
public class PaymentsServiceImpl implements PaymentsService {

	@Autowired
	private PaymentsRepository paymentsRepository;

	@Override
	public Payments getOne(Integer paymentId) {
		return paymentsRepository.findById(paymentId).get();
	}

	@Override
	public Boolean delete(Integer paymentId) {
		if (paymentsRepository.getOne(paymentId) != null) {
			paymentsRepository.deleteById(paymentId);
			return true;
		}
		return false;
	}

	@Override
	public Payments create(Payments payments) {
		return paymentsRepository.save(payments);
	}

	@Override
	public Payments update(Payments paymentsToUpdate) {
						Payments payments = paymentsRepository.getOne(paymentsToUpdate.getPaymentId());
																		
//				if(paymentsToUpdate.getPaymentStatusCode() !=null) {
//			
//		}
//				if(paymentsToUpdate.getPaymentDate() !=null) {
//			
//		}
//				if(paymentsToUpdate.getPaymentAmount() !=null) {
//			
//		}
				return paymentsRepository.save(payments);
	}

	@Override
	public Boolean exist(Payments payments) {
						return paymentsRepository.existsById(payments.getPaymentId());
																	}

	@Override
	public List<Payments> findAll() {
		return paymentsRepository.findAll();
	}

	@Override
	public Page<Payments> findAll(Pageable pageable) {
		return paymentsRepository.findAll(pageable);
	}
}




