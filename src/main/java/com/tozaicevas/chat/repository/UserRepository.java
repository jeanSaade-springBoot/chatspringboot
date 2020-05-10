package com.tozaicevas.chat.repository;

import com.tozaicevas.chat.model.User;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByToken(String token);
	
	@Query(value = "SELECT chat.SEQUENCE_NAME.nextval FROM dual", nativeQuery = true)
    public BigDecimal getNextValMySequence();
	
}
