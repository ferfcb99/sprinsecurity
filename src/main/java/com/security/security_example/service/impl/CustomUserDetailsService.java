package com.security.security_example.service.impl;

import com.security.security_example.entity.User;
import com.security.security_example.repository.UserDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDao userDao;

    public CustomUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userDao.findByUsername(username);

        if(user.isPresent()) {
            System.out.println(user.get().getUsername());
            System.out.println(user.get().getPassword());
            return (UserDetails) user.get();
        }

        throw new UsernameNotFoundException("Not found : " + username);

    }
}
