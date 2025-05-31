package com.university.address_service.addressController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.address_service.request.AddressRequest;
import com.university.address_service.response.AddressResponse;
import com.university.address_service.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	private AddressService addressService;
	
	@Autowired
	public AddressController(AddressService addressService){
		this.addressService = addressService;
	}

	@GetMapping("/getById/{id}")
	public AddressResponse getAddress(@PathVariable Long id) {
		return addressService.getbyId(id);	
	}
	
	@PostMapping("/create")
	public AddressResponse createAddress(@RequestBody AddressRequest addreq) {
		return addressService.create(addreq);	
		
	}
}
