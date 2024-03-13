package org.teamraccoon.dreamfusion.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.teamraccoon.dreamfusion.users.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    
    UserRepository repository;

    public JpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return repository
                .findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow( () -> new UsernameNotFoundException("User not found" + username));
    }

    
}
