package com.medisite.medicos.service;

import com.medisite.medicos.DTO.MedicoDTO;
import com.medisite.medicos.repository.entity.EspecialidadEntity;
import com.medisite.medicos.repository.entity.MedicoEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface MedicoService {
    public MedicoDTO createMedico(MedicoEntity medico);

    public MedicoDTO updateMedico(MedicoEntity medico);

    public void deleteMedico(long id_medico);

    public MedicoDTO getMedicoById(long id_medico);

    public List<MedicoDTO> getAllMedicos();

    public List<EspecialidadEntity> getEspecialidades();

    public List<MedicoDTO> filterByEspecialidad(List<MedicoDTO> medicos, long id_especialidad);

    public List<MedicoDTO> filterByCiudad(List<MedicoDTO> medicos, long id_ciudad);

    public List<MedicoDTO> filterByDisponibilidad(List<MedicoDTO> medicos, LocalDateTime fecha_inicio, LocalDateTime fecha_fin);
}
