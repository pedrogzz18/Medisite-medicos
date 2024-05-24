package com.medisite.medicos.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginResponse{
    private String token;
    private long expiresIn;

    private MedicoDTO medicoDTO;
}