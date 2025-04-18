package com.server.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.server.backend.models.entities.User;
import com.server.backend.repositories.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

  @Autowired
  public UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(email);

    if (user == null) {
      System.out.println("User not found");
      throw new UsernameNotFoundException("user not found");
    }

    return new UserPrinciple(user);
  }

}
