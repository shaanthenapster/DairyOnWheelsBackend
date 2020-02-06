package com.dairy.repository;

import com.dairy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User , Long> {

    User findByContact(String mobileno);

}
