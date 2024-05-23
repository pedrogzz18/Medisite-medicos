package com.medisite.medicos.controller;

import com.medisite.medicos.DTO.MedicoDTO;
import com.medisite.medicos.DTO.TimeRangeRequest;
import com.medisite.medicos.repository.entity.EspecialidadEntity;
import com.medisite.medicos.repository.entity.MedicoEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/medicos")
public interface MedicosController {

    @PostMapping("/create-medico")
    public ResponseEntity<?> createMedico(HttpServletRequest request, @RequestBody MedicoEntity medico);

    @PutMapping("/update-medico/{id}")
    public ResponseEntity<?> updateMedico(HttpServletRequest request, @PathVariable long id_medico, @RequestBody MedicoEntity medico);

    @DeleteMapping("/delete-medico/{id}")
    public ResponseEntity<?> deleteMedico(HttpServletRequest request, @PathVariable long id_medico);

    @GetMapping("/get-medico/{id}")
    public ResponseEntity<?> getMedicoById(HttpServletRequest request, @PathVariable long id_medico);

    @GetMapping("/get-medicos")
    public ResponseEntity<?> getMedicos(HttpServletRequest request,
                                           @RequestParam(value = "id_especialidad", required = false) Long id_especialidad,
                                           @RequestParam(value = "id_ciudad", required = false) Long id_ciudad,
                                           @RequestBody(required = false) TimeRangeRequest time_range);

    @GetMapping("/get-especialidades")
    public ResponseEntity<?> getAllEspecialidades(HttpServletRequest request);
}
