package com.dhjo.dhjo_be.controller;

import com.dhjo.dhjo_be.constant.Enum;
import com.dhjo.dhjo_be.constant.ErrorMessage;
import com.dhjo.dhjo_be.constant.RestURL;
import com.dhjo.dhjo_be.model.dto.JwtAuthResponseDTO;
import com.dhjo.dhjo_be.model.dto.LoginDTO;
import com.dhjo.dhjo_be.model.dto.SignUpDTO;
import com.dhjo.dhjo_be.model.entity.Role;
import com.dhjo.dhjo_be.model.entity.User;
import com.dhjo.dhjo_be.repository.RoleRepository;
import com.dhjo.dhjo_be.repository.UserRepository;
import com.dhjo.dhjo_be.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@RestController
public class AuthController {
    private AuthenticationManager authenticationManager;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          RoleRepository roleRepository,
                          UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping(RestURL.USER_LOGIN_API_URL)
    public ResponseEntity<JwtAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO){
        // authenticate login info
        Authentication auth_obj = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername_or_email(), loginDTO.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(auth_obj);
        // create jwt token and send back to user
        String token = this.jwtTokenProvider.generateToken(auth_obj);
        return new ResponseEntity<>(new JwtAuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping(RestURL.OWNER_SIGNUP_API_URL)
    public ResponseEntity<String> registerOwner(@RequestBody SignUpDTO signUpDTO){
        if(this.userRepository.existsByUsername(signUpDTO.getUsername())){
            return new ResponseEntity<>(ErrorMessage.USERNAME_ALREADY_USED, HttpStatus.BAD_REQUEST);
        }
        else if(this.userRepository.existsByEmail(signUpDTO.getEmail())){
            return new ResponseEntity<>(ErrorMessage.EMAIL_ALREADY_USED, HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setCreated_at(new Date().getTime());
        user.setUsername(signUpDTO.getUsername());
        user.setEmail(signUpDTO.getEmail());
        user.setPassword(this.passwordEncoder.encode(signUpDTO.getPassword()));
        Role role = this.roleRepository.findByRole_name(Enum.ROLE.ROLE_OWNER);
        user.setRoles(Collections.singleton(role));
        this.userRepository.save(user);
        return new ResponseEntity<>(ErrorMessage.USER_REGISTERED, HttpStatus.OK);
    }
}
