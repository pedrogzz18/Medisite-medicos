package com.medisite.medicos.controller.impl;

import com.medisite.medicos.DTO.MedicoDTO;
import com.medisite.medicos.controller.MedicosController;
import com.medisite.medicos.repository.entity.MedicoEntity;
import com.medisite.medicos.service.MedicoService;
import com.medisite.medicos.utils.MedicoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicosControllerImpl implements MedicosController {
    @Autowired
    private MedicoService medicoService;
    @Override
    public MedicoDTO createMedico(@RequestBody MedicoEntity medico){
        MedicoDTO dto = new MedicoDTO();
        dto.setEmail(medico.getEmail());
        return dto;
    }

    @Override
    public MedicoDTO updateMedico(@PathVariable long id_medico, @RequestBody MedicoEntity medico){
        medico.setIdMedico(id_medico);
        return medicoService.updateMedico(medico);
    }

    @Override
    public void deleteMedico(@PathVariable long id_medico){
        medicoService.deleteMedico(id_medico);
    }

    @Override
    public MedicoDTO getMedicoById(@PathVariable long id_medico){
        return medicoService.getMedicoById(id_medico);
    }

    @Override
    public List<MedicoDTO> getAllMedicos(){
        return medicoService.getAllMedicos();
    }
}
