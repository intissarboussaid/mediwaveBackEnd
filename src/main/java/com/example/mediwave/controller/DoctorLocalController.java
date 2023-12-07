package com.example.mediwave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mediwave.modal.DoctorLocal;
import com.example.mediwave.modal.LocalPhysio;
import com.example.mediwave.repository.DoctorLocalRepository;
import com.example.mediwave.service.DoctorLocalService;

@RestController
@RequestMapping("/api/doctorlocal")
public class DoctorLocalController {
	
	 @Autowired
	  DoctorLocalRepository doctorLocalRepository;
	 @Autowired
	  DoctorLocalService doctorLocalService;
	 
	 @PostMapping("/post")
	  public DoctorLocal createTherapeute(@RequestBody DoctorLocal physioLocal) {      	
	    	return doctorLocalService.createNewTherapeute(physioLocal);	      
	  }
	 @PutMapping("/update/{id_doctor}")
	  public DoctorLocal UpdatePhysioTherapeute(@PathVariable(value="id_doctor") long id_doctor,@RequestBody DoctorLocal doctorLocal) {      	
		 DoctorLocal Therapeute = doctorLocalRepository.findById(id_doctor);
		 Therapeute.set_id(doctorLocal.get_id());
		 Therapeute.setActs_et_soins(doctorLocal.getActs_et_soins());
		 Therapeute.setAdresse(doctorLocal.getAdresse());
		 Therapeute.setLat(doctorLocal.getLat());
		 Therapeute.setMail(doctorLocal.getMail());
		 Therapeute.setQualification_personnel(doctorLocal.getQualification_personnel());
		 Therapeute.setSpecialty(doctorLocal.getSpecialty());
		 Therapeute.setGenre(doctorLocal.getGenre());
		 Therapeute.setGouvernorat(doctorLocal.getGouvernorat());
		 Therapeute.setLng(doctorLocal.getLng());
		 Therapeute.setName(doctorLocal.getName());
		 Therapeute.setPhone1(doctorLocal.getPhone1());
		 Therapeute.setPhone2(doctorLocal.getPhone2());
		 Therapeute.setPrename(doctorLocal.getPrename());
		 Therapeute.set_id(doctorLocal.get_id());
		 Therapeute.setImg(doctorLocal.getImg());
		 Therapeute.setFeatured(doctorLocal.isFeatured());				
			//this.media = media;
	    	return doctorLocalRepository.save(Therapeute);	      
	  }
	 
	 @GetMapping("AllTherapeute")
	  public List<DoctorLocal> DisplayAllTherapeute(){
		  return doctorLocalRepository.findAll();
	  }
	 @GetMapping("GetById/{id_doctor}")
	  public DoctorLocal DisplayTherapeuteById(@PathVariable(value = "id_doctor")long id_doctor){
		  return doctorLocalRepository.findById(id_doctor);
	  }
	 @DeleteMapping("deleteById/{id_doctor}")
	  public List<DoctorLocal> DeletePhysioTherapeuteById(@PathVariable(value = "id_doctor")long id_doctor){
		 doctorLocalRepository.deleteById(id_doctor);
		  return doctorLocalRepository.findAll();
	  }

}
