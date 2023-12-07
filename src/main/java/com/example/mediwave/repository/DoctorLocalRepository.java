package com.example.mediwave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mediwave.modal.DoctorLocal;

@Repository
public interface DoctorLocalRepository extends JpaRepository<DoctorLocal, Long> {
	  @Query("from DoctorLocal where id_doctor =:id_doctor")
	  DoctorLocal findById(@Param("id_doctor")long id_doctor);


}
