package com.medisite.medicos.service;

import com.medisite.medicos.DTO.LoginResponse;
import com.medisite.medicos.DTO.MedicoDTO;
import com.medisite.medicos.DTO.MedicoLoginDTO;
import com.medisite.medicos.configs.JwtFilter;
import com.medisite.medicos.repository.MedicoRepository;
import com.medisite.medicos.repository.entity.MedicoEntity;
import com.medisite.medicos.utils.MedicoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public ResponseEntity<MedicoDTO> signup(MedicoEntity medicoEntity){
        medicoEntity.setContraseña(passwordEncoder.encode(medicoEntity.getContraseña()));
        return ResponseEntity.ok(medicoService.createMedico(medicoEntity));
    }


    public ResponseEntity<LoginResponse> login(MedicoLoginDTO medicoLoginDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                medicoLoginDTO.getEmail(), medicoLoginDTO.getPassword()));
        MedicoDTO medicoDTO = MedicoEntityMapper.MedicoEntitytoMedicoDTO(medicoRepository.findByEmail(medicoLoginDTO.getEmail()));
        String jwtToken = jwtService.generateToken(medicoLoginDTO.getEmail(), "medico", medicoDTO.getIdMedico());
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getJwtExpiration(), medicoDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
