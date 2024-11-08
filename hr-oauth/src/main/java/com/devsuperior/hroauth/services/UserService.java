package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclient.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(s).getBody();
        if (user == null) {
            logger.error("Email not found" + s);
            throw new UsernameNotFoundException("Invalid email");
        }
        logger.info("Found user with email " + user.getEmail());
        return user;
    }
}
