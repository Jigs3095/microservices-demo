package com.university.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.app.feignClient.AddressFeignClient;
import com.university.app.repository.StudentRepo;
import com.university.app.response.AddressResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {
	
	Logger logger = LoggerFactory.getLogger(CommonService.class);
	long count=1;
	
	private AddressFeignClient addressFeignClient;
	@Autowired
	CommonService(StudentRepo strepo, AddressFeignClient addressFeignClient){
		this.addressFeignClient=addressFeignClient;
	}
	
	
	@CircuitBreaker(name="addressService", fallbackMethod="fallbackGetAddressById")
	public AddressResponse getAddressById(Long id) {
		logger.info("count = "+count);
		count++;
		AddressResponse add = addressFeignClient.getAddress(id);
		return add;
	}
	
	public AddressResponse fallbackGetAddressById(Long id, Throwable th) {
		logger.error("Error --" + th);
		return new AddressResponse();
		 
	}

}
