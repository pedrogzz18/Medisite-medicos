package com.medisite.medicos.repository;

import com.medisite.medicos.DTO.MedicoDTO;
import com.medisite.medicos.repository.entity.MedicoEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomizedMedicoRepository {
    public List<MedicoEntity> getMedicosByDispoibilidad(LocalDateTime horaInicio, LocalDateTime horaFin);
}
