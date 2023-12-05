package com.ofrs.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ofrs.model.RegisterUser;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Integer>{
	RegisterUser findByUserEmail(String userEmail);
	RegisterUser findByUserName(String userName);
	@Query("SELECT u FROM RegisterUser u WHERE u.verificationCode = ?1")
    public RegisterUser findByVerificationCode(String code);
}
