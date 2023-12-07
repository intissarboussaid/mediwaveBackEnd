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

import com.example.mediwave.modal.LocalPhysio;
import com.example.mediwave.repository.PhysioLocalRepository;
import com.example.mediwave.service.PhysioLocalService;

@RestController
@RequestMapping("/api/physiolocal")
public class PhysioLocalController {
	 @Autowired
	  PhysioLocalRepository physiolocalRepository;
	 @Autowired
	  PhysioLocalService physioLocalService;
	 
	 @PostMapping("/post")
	  public LocalPhysio createPhysioTherapeute(@RequestBody LocalPhysio physioLocal) {      	
	    	return physioLocalService.createNewPhsioTherapeute(physioLocal);	      
	  }
	 @PutMapping("/update/{idphysio}")
	  public LocalPhysio UpdatePhysioTherapeute(@PathVariable(value="idphysio") long idphysio,@RequestBody LocalPhysio physioLocal) {      	
		 LocalPhysio physioTherapeute = physiolocalRepository.findById(idphysio);
		 physioTherapeute.set_id(physioLocal.get_id());
		 physioTherapeute.setActs_et_soins(physioLocal.getActs_et_soins());
		 physioTherapeute.setAdresse(physioLocal.getAdresse());
		 physioTherapeute.setLat(physioLocal.getLat());
		 physioTherapeute.setMail(physioLocal.getMail());
		 physioTherapeute.setQualification_personnel(physioLocal.getQualification_personnel());
		 physioTherapeute.setSpecialty(physioLocal.getSpecialty());
		 physioTherapeute.setGenre(physioLocal.getGenre());
		 physioTherapeute.setGouvernorat(physioLocal.getGouvernorat());
		 physioTherapeute.setLng(physioLocal.getLng());
		 physioTherapeute.setName(physioLocal.getName());
		 physioTherapeute.setPhone1(physioLocal.getPhone1());
		 physioTherapeute.setPhone2(physioLocal.getPhone2());
		 physioTherapeute.setPrename(physioLocal.getPrename());
		 physioTherapeute.set_id(physioLocal.get_id());
		 physioTherapeute.setImg(physioLocal.getImg());
		 physioTherapeute.setFeatured(physioLocal.isFeatured());		
			//this.media = media;
	    	return physiolocalRepository.save(physioTherapeute);	      
	  }
	 
	 @GetMapping("AllPhysioTherapeute")
	  public List<LocalPhysio> DisplayAllPhysioTherapeute(){
		  return physiolocalRepository.findAll();
	  }
	 @GetMapping("GetById/{idphysio}")
	  public LocalPhysio DisplayPhysioTherapeuteById(@PathVariable(value = "idphysio")long idphysio){
		  return physiolocalRepository.findById(idphysio);
	  }
	 @DeleteMapping("deleteById/{idphysio}")
	  public List<LocalPhysio> DeletePhysioTherapeuteById(@PathVariable(value = "idphysio")long idphysio){
		physiolocalRepository.deleteById(idphysio);
		  return physiolocalRepository.findAll();
	  }
}
