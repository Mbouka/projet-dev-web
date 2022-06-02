package com.projetWeb.citwe.respository;


import com.projetWeb.citwe.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findUserByEmail(String email);
}