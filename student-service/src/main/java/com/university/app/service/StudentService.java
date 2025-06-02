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
	CommonService commonService;
	@Autowired
	StudentService(StudentRepo strepo, CommonService commonService){
		this.strepo = strepo;
		this.commonService=commonService;
	}
	
	public StudentResponse getStudentById(Long id) {
		Student st = strepo.findById(id).get();
		StudentResponse res = new StudentResponse(st);
		res.setAddressResponse(commonService.getAddressById(st.getAddressId()));
		return res;
	}
	
		
}
