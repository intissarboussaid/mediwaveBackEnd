package com.example.mediwave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mediwave.modal.DoctorLocal;
import com.example.mediwave.repository.DoctorLocalRepository;

@Service
public class DoctorLocalService {
	@Autowired  
	DoctorLocalRepository doctorLocalRepository;
	
	
	public DoctorLocal createNewTherapeute(DoctorLocal doctorLocal ) {
		return doctorLocalRepository.save(doctorLocal);
	}

}
