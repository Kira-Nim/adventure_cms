package com.adventurealley.adventure_cms.security;

import com.adventurealley.adventure_cms.model.User;
import com.adventurealley.adventure_cms.model.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Arrays;
import java.util.List;



public class UserDetailsServiceImpl implements UserDetailsService{

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<User> userList = userRepository.findByUsername(username);

        if (userList.size() == 0) {
            throw new UsernameNotFoundException("User is not Found");
        }

        User user = userList.get(0);

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("user")));
    }
}
