package com.university.address_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.address_service.entity.Address;
import com.university.address_service.repository.AddressRepository;
import com.university.address_service.request.AddressRequest;
import com.university.address_service.response.AddressResponse;

@Service
public class AddressService {
	private AddressRepository addressRepo;	
	
	@Autowired
	public AddressService(AddressRepository addressRepo) {
		this.addressRepo = addressRepo;
	}
	
	public AddressResponse getbyId(Long id) {
		return new AddressResponse(addressRepo.findById(id).get());
	}
	
	public AddressResponse create(AddressRequest addreq) {
		Address add = new Address();
		add.setCity(addreq.getCity());
		add.setStreet(addreq.getStreet());
		addressRepo.save(add);
		return new AddressResponse(add);
	}
	
	
}
