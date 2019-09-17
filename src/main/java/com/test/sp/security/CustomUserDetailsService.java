package com.test.sp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.sp.domain.User;
import com.test.sp.repository.UserRepository;
/**
 * 
 *
 * @param 
 * @return
 * @throws 
 * @date 2019-09-17
 * @author choiseongjun
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired 
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String idOrname)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = userRepository.findByIdOrName(idOrname, idOrname)
                .orElseThrow(() -> 
                        new UsernameNotFoundException("User not found with username or email : " + idOrname)
        );

        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("User not found with id : " + id)
        );
      

        return UserPrincipal.create(user);
    }
}