package com.wfh.mobilestorespring.services;

import com.wfh.mobilestorespring.model.CustomUserDetails;
import com.wfh.mobilestorespring.model.User;
import com.wfh.mobilestorespring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null) throw new UsernameNotFoundException(username);
        return new CustomUserDetails(user);
    }
}
