package com.dairy.repository;

import com.dairy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User , Long> {

    User findByContact(String mobileno);

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);


}
