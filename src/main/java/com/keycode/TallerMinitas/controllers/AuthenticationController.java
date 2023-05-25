package com.keycode.TallerMinitas.controllers;

import com.keycode.TallerMinitas.dto.LoginResponseDTO;
import com.keycode.TallerMinitas.dto.RegistrationDTO;
import com.keycode.TallerMinitas.models.ApplicationUser;
import com.keycode.TallerMinitas.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return  authenticationService.registerUser(body.getUserName(), body.getPassword(), body.getCity());

    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUserName(), body.getPassword());
    }

}
