package com.projetWeb.citwe.respository;



import com.projetWeb.citwe.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findUserByRole(String role);

}
