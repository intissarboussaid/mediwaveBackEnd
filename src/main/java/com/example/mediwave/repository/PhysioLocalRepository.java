package com.example.mediwave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.mediwave.modal.LocalPhysio;

public interface PhysioLocalRepository extends JpaRepository<LocalPhysio, Long> {
	
	  @Query("from LocalPhysio where idphysio =:idphysio")
	  LocalPhysio findById(@Param("idphysio")long idphysio);

}
