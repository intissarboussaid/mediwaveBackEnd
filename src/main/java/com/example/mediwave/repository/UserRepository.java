package com.example.mediwave.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mediwave.modal.Account;
import com.example.mediwave.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("from User where account =:account" )
	User findByAccount(@Param("account") Account account);
	
}
