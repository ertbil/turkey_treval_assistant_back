package com.example.treavelAppback.service;


import com.example.treavelAppback.consts.enums.Role;
import com.example.treavelAppback.model.db_models.User;
import com.example.treavelAppback.model.request_models.AuthenticationRequest;
import com.example.treavelAppback.model.response_models.AuthenticationResponse;
import com.example.treavelAppback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(User requestUser) { //TODO it can be better
        User user = User.builder()
                .firstName(requestUser.getFirstName())
                .lastName(requestUser.getLastName())
                .username(requestUser.getUsername())
                .password(passwordEncoder.encode(requestUser.getPassword()))
                .role(Role.USER)
                .email(requestUser.getEmail())
                .build();

        userRepository.save(user);
        return buildResponse(user);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        User user = userRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow();
        return buildResponse(user);

    }

    private AuthenticationResponse buildResponse(User user) {
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .jwt(jwt)
                .build();
    }


}