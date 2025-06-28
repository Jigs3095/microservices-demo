package com.university.address_service.addressController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.address_service.request.AddressRequest;
import com.university.address_service.response.AddressResponse;
import com.university.address_service.service.AddressService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@Validated
@RequestMapping("/api/address")
public class AddressController {
	
	private AddressService addressService;
	
	@Autowired
	public AddressController(AddressService addressService){
		this.addressService = addressService;
	}

	@Value("${message}")
	private String message;

	@GetMapping("/message")
	public String getMessage() {
		return message;
	}

	@GetMapping("/getById/{id}")
	public AddressResponse getAddress(@PathVariable @Min(1) Long id) {
		return addressService.getbyId(id);	
	}
	
	@PostMapping("/create")
	public ResponseEntity<AddressResponse> createAddress(@Valid @RequestBody AddressRequest addreq) {
		return ResponseEntity.ok(addressService.create(addreq));	
		
	}
}
