package com.medisite.medicos.controller;

import com.medisite.medicos.DTO.MedicoDTO;
import com.medisite.medicos.repository.entity.EspecialidadEntity;
import com.medisite.medicos.repository.entity.MedicoEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/medicos")
public interface MedicosController {

    @PostMapping("/create-medico")
    public MedicoDTO createMedico(@RequestBody MedicoEntity medico);

    @PutMapping("/update-medico/{id}")
    public MedicoDTO updateMedico(@PathVariable long id_medico, @RequestBody MedicoEntity medico);

    @DeleteMapping("/delete-medico/{id}")
    public void deleteMedico(@PathVariable long id_medico);

    @GetMapping("/get-medico/{id}")
    public MedicoDTO getMedicoById(@PathVariable long id_medico);

    @GetMapping("/get-all")
    public List<MedicoDTO> getAllMedicos();
}
