package com.medisite.medicos.utils;

import com.medisite.medicos.DTO.MedicoDTO;
import com.medisite.medicos.repository.entity.MedicoEntity;

public class MedicoEntityMapper {
    public static MedicoDTO MedicoEntitytoMedicoDTO(MedicoEntity medicoEntity){
        MedicoDTO medicoDTO = new MedicoDTO(medicoEntity.getIdMedico(),
                                    medicoEntity.getNombre(),
                                    medicoEntity.getApellidoPaterno(),
                medicoEntity.getApellidoMaterno(),
                medicoEntity.getFechaNacimiento(),
                medicoEntity.getIdEspecialidad(),
                medicoEntity.getEmail(),
                medicoEntity.getTelefono(),
                medicoEntity.getIdCiudad(),
                medicoEntity.getColonia(),
                medicoEntity.getDomicilio(),
                medicoEntity.getCp()
                );
        return medicoDTO;
    }
}
