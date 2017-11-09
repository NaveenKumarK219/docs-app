package com.mdoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mdoc.model.User;
import com.mdoc.repository.RoleRepository;
import com.mdoc.repository.UserRepository;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getUsers() {

	return userRepository.findAllByOrderById();
    }

    public User findUserByEmail(String email) {
	return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	user.setActive(true);
	/*
	 * Role userRole = roleRepository.findByRole("ADMIN"); user.setRoles(new
	 * HashSet<Role>(Arrays.asList(userRole)));
	 */
	userRepository.save(user);

    }

    public void deleteUser(int id) {

	userRepository.delete(userRepository.findById(id));
    }

    public void blockUser(int id) {
	userRepository.blockUser(id);
    }

    public void unBlockUser(int id) {
	userRepository.unBlockUser(id);
    }

}
