package com.medisite.medicos.service.impl;

import com.medisite.medicos.DTO.MedicoDTO;
import com.medisite.medicos.repository.EspecialidadRepository;
import com.medisite.medicos.repository.MedicoRepository;
import com.medisite.medicos.repository.entity.EspecialidadEntity;
import com.medisite.medicos.repository.entity.MedicoEntity;
import com.medisite.medicos.service.MedicoService;
import com.medisite.medicos.utils.MedicoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;
    public MedicoDTO createMedico(MedicoEntity medico){
        return MedicoEntityMapper.MedicoEntitytoMedicoDTO(medicoRepository.save(medico));
    }

    public MedicoDTO updateMedico(MedicoEntity medico){
        return MedicoEntityMapper.MedicoEntitytoMedicoDTO(medicoRepository.save(medico));
    }

    public void deleteMedico(long id_medico){
        medicoRepository.deleteById(id_medico);
    }

    public MedicoDTO getMedicoById(long id_medico){
        return MedicoEntityMapper.MedicoEntitytoMedicoDTO(medicoRepository.findById(id_medico).get());
    }

    public List<MedicoDTO> getAllMedicos(){
        List<MedicoEntity> medicoEntityList = (List<MedicoEntity>) medicoRepository.findAll();
        List<MedicoDTO> medicoDTOS = new ArrayList<MedicoDTO>();
        for(MedicoEntity medico : medicoEntityList){
            medicoDTOS.add(MedicoEntityMapper.MedicoEntitytoMedicoDTO(medico));
        }
        return medicoDTOS;
    }

    public List<EspecialidadEntity> getEspecialidades(){
        return (List<EspecialidadEntity>) especialidadRepository.findAll();
    }

    public List<MedicoEntity> filterByEspecialidad(List<MedicoEntity> medicos, long id_especialidad){
        List<MedicoEntity> results = new ArrayList<MedicoEntity>();

        for(MedicoEntity e : medicos){
            if(e.getIdEspecialidad() == id_especialidad) results.add(e);
        }
        return results;
    }

    public List<MedicoEntity> filterByCiudad(List<MedicoEntity> medicos, long id_ciudad){
        List<MedicoEntity> results = new ArrayList<MedicoEntity>();

        for(MedicoEntity e : medicos){
            if(e.getIdCiudad() == id_ciudad) results.add(e);
        }
        return results;
    }

    public List<MedicoEntity> filterByDisponibilidad(List<MedicoEntity> medicos, LocalDateTime fecha_inicio, LocalDateTime fecha_fin){
        return null;
    }

}
