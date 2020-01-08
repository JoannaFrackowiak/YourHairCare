package com.homeproject.yourhaircare.config;


import com.homeproject.yourhaircare.model.User;
import com.homeproject.yourhaircare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService  implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userByEmail = userRepository.findUserByEmail(username);

        if(userByEmail == null){
            throw new UsernameNotFoundException("User does not exist!");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(userByEmail.getEmail())
                .password("{noop}" + userByEmail.getPassword())
                .roles("ADMIN")
                .build();
    }
}
