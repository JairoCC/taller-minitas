package com.keycode.TallerMinitas.services;

import com.keycode.TallerMinitas.dto.LoginResponseDTO;
import com.keycode.TallerMinitas.models.ApplicationUser;
import com.keycode.TallerMinitas.models.Role;
import com.keycode.TallerMinitas.repository.RoleRepository;
import com.keycode.TallerMinitas.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ApplicationUser registerUser(String userName, String password, String city){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepository.save(new ApplicationUser(0, userName, encodedPassword, city, authorities));
    }

    public LoginResponseDTO loginUser(String userName, String password){

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password)
        );

        String token = tokenService.generateJwt(auth);
        return new LoginResponseDTO(userRepository.findByUserName(userName).get(), token);

    }
}
