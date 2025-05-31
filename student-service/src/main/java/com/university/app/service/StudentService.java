package com.university.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.app.entity.Student;
import com.university.app.feignClient.AddressFeignClient;
import com.university.app.repository.StudentRepo;
import com.university.app.response.AddressResponse;
import com.university.app.response.StudentResponse;

@Service
public class StudentService {
	
	private StudentRepo strepo; 
	AddressFeignClient addressFeignClient;
	@Autowired
	StudentService(StudentRepo strepo, AddressFeignClient addressFeignClient){
		this.strepo = strepo;
		this.addressFeignClient=addressFeignClient;
	}
	
	public StudentResponse getStudentById(Long id) {
		Student st = strepo.findById(id).get();
		AddressResponse add = addressFeignClient.getAddress(st.getAddressId());
		StudentResponse res = new StudentResponse(st);
		res.setAddId(add.getAddressId());
		res.setCity(add.getCity());
		res.setStreet(add.getStreet());
		return res;
	}
	
}
