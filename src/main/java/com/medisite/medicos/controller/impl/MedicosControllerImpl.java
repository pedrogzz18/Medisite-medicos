package com.medisite.medicos.controller.impl;

import com.medisite.medicos.DTO.MedicoDTO;
import com.medisite.medicos.controller.MedicosController;
import com.medisite.medicos.repository.entity.MedicoEntity;
import com.medisite.medicos.service.JwtService;
import com.medisite.medicos.service.MedicoService;
import com.medisite.medicos.utils.MedicoEntityMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MedicosControllerImpl implements MedicosController {
    @Autowired
    private MedicoService medicoService;

    @Autowired
    private JwtService jwtService;
    @Override
    public ResponseEntity<?> createMedico(HttpServletRequest request,  @RequestBody MedicoEntity medico){
        String token = jwtService.getBearerToken(request);
        if(jwtService.isAdmin(token)) {
            return ResponseEntity.ok(medicoService.createMedico(medico));
        }
        return ResponseEntity.status(403).body("not authorized");
    }

    @Override
    public ResponseEntity<?> updateMedico(HttpServletRequest request, @PathVariable long id_medico, @RequestBody MedicoEntity medico){
        String token = jwtService.getBearerToken(request);
        if((jwtService.isMedico(token) && jwtService.validateIdInToken(token, id_medico))
            || jwtService.isAdmin(token)){
            medico.setIdMedico(id_medico);
            return ResponseEntity.ok(medicoService.updateMedico(medico));
        }
        return ResponseEntity.status(403).body("not authorized");
    }

    @Override
    public ResponseEntity<?> deleteMedico(HttpServletRequest request, @PathVariable long id_medico){
        String token = jwtService.getBearerToken(request);
        if((jwtService.isMedico(token) && jwtService.validateIdInToken(token, id_medico))
                || jwtService.isAdmin(token)){
            medicoService.deleteMedico(id_medico);
            return ResponseEntity.ok("medico eliminado");
        }
        return ResponseEntity.status(403).body("not authorized");
    }

    @Override
    public ResponseEntity<?> getMedicoById(HttpServletRequest request, @PathVariable long id_medico){
        String token = jwtService.getBearerToken(request);
        if((jwtService.isMedico(token) && jwtService.validateIdInToken(token, id_medico))
                || jwtService.isPaciente(token)
                || jwtService.isAdmin(token)){
            return ResponseEntity.ok(medicoService.getMedicoById(id_medico));
        }
        return ResponseEntity.status(403).body("not authorized");
    }

    @Override
    public ResponseEntity<?> getAllMedicos(HttpServletRequest request){
        String token = jwtService.getBearerToken(request);
        if(jwtService.isMedico(token)
                || jwtService.isPaciente(token)
                || jwtService.isAdmin(token)){
            return ResponseEntity.ok(medicoService.getAllMedicos());
        }
        return ResponseEntity.status(403).body("not authorized");
    }
}
