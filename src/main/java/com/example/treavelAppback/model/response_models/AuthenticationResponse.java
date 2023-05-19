package com.example.treavelAppback.model.response_models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse { //TODO integrate with ResponseDTO

    private String jwt;
}
