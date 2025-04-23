package psu.edu.mvcsecurity.service;

import psu.edu.mvcsecurity.entity.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

}