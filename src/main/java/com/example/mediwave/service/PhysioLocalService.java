package com.example.mediwave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mediwave.modal.LocalPhysio;
import com.example.mediwave.repository.PhysioLocalRepository;

@Service
public class PhysioLocalService {
	@Autowired  
	PhysioLocalRepository physioLocalRepository;
	
	
	public LocalPhysio createNewPhsioTherapeute(LocalPhysio physiolLocal ) {
		return physioLocalRepository.save(physiolLocal);
	}

}
