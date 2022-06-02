package com.projetWeb.citwe.service;


import java.util.Arrays;
import java.util.HashSet;


import com.projetWeb.citwe.model.entities.Role;
import com.projetWeb.citwe.model.entities.User;
import com.projetWeb.citwe.respository.RoleRepository;
import com.projetWeb.citwe.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;




@Service("userService")
public class UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserRepository userRepository,//injection des dependances en passant par le constructeur
			RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);

		final Role userRole = roleRepository.findUserByRole("ADMIN");

		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));


		return userRepository.save(user);
	}


}