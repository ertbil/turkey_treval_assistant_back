package com.example.treavelAppback.controller;

import com.example.treavelAppback.consts.strings.Paths;
import com.example.treavelAppback.model.db_models.User;
import com.example.treavelAppback.model.request_models.AuthenticationRequest;
import com.example.treavelAppback.model.request_models.RegisterRequest;
import com.example.treavelAppback.model.response_models.AuthenticationResponse;
import com.example.treavelAppback.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.authPath)
@RequiredArgsConstructor
public class AuthController {

    AuthService service;


    @PostMapping(Paths.registerPath)
    public ResponseEntity<AuthenticationResponse<RegisterRequest>> register(@RequestBody RegisterRequest user) {

        System.out.println("Registering user: " + user);

        try {
            service.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(new AuthenticationResponse<RegisterRequest>(user));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AuthenticationResponse<RegisterRequest>(ex.getMessage()));
        }
    }

    @PostMapping(Paths.authenticatePath)
    public ResponseEntity<AuthenticationResponse<AuthenticationRequest>> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {

        try {
            service.authenticate(authenticationRequest);
            return ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponse<AuthenticationRequest>(authenticationRequest));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AuthenticationResponse<AuthenticationRequest>(ex.getMessage()));
        }

    }

}
