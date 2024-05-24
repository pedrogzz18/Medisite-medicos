package com.medisite.medicos.controller;

import com.medisite.medicos.DTO.LoginResponse;
import com.medisite.medicos.DTO.MedicoDTO;
import com.medisite.medicos.DTO.MedicoLoginDTO;
import com.medisite.medicos.repository.entity.MedicoEntity;
import com.medisite.medicos.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/medicos/auth")
@RestController
public class AuthController {
    @Autowired
    private AuthService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<MedicoDTO> signup(@RequestBody MedicoEntity medico){
        return authenticationService.signup(medico);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody MedicoLoginDTO medicoLoginDTO){
        return authenticationService.login(medicoLoginDTO);
    }
}
