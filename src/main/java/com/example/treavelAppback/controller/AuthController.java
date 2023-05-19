package com.example.treavelAppback.controller;

import com.example.treavelAppback.consts.strings.Paths;
import com.example.treavelAppback.model.db_models.User;
import com.example.treavelAppback.model.request_models.AuthenticationRequest;
import com.example.treavelAppback.model.response_models.AuthenticationResponse;
import com.example.treavelAppback.service.AuthService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User user) {
       return ResponseEntity.ok(service.register(user));
    }

    @PostMapping(Paths.authenticatePath)
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(service.authenticate(authenticationRequest));
        //TODO register
    }

}
