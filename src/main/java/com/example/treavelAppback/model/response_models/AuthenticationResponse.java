package com.example.treavelAppback.model.response_models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse<T> extends ResponseDao<T> { //TODO integrate with ResponseDTO

    private String jwt;

    public AuthenticationResponse(boolean success, T data, String error) {
        super(success, data, error);
    }

    public AuthenticationResponse(T data) {
        super(data);
    }

    public AuthenticationResponse(String error) {
        super(error);
    }
}
