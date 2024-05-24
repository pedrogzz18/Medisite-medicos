package com.medisite.medicos.repository.impl;

import com.medisite.medicos.DTO.MedicoDTO;
import com.medisite.medicos.repository.CustomizedMedicoRepository;
import com.medisite.medicos.repository.entity.MedicoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.List;

public class CustomizedMedicoRepositoryImpl implements CustomizedMedicoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MedicoEntity> getMedicosByDispoibilidad(LocalDateTime horaInicio, LocalDateTime horaFin){
        List<MedicoEntity> medicosList =
                em.createNativeQuery("SELECT * FROM medico AS m WHERE m.id_medico NOT IN (" +
                "SELECT m.id_medico FROM medico as m INNER JOIN cita as c ON c.id_medico = m.id_medico " +
                "WHERE (c.hora_inicio BETWEEN :horaInicio AND :horaFin) OR " +
                "(c.hora_fin BETWEEN :horaInicio AND :horaFin) OR " +
                "(c.hora_inicio < :horaInicio AND c.hora_fin > :horaFin))", MedicoEntity.class)
                .setParameter("horaInicio", horaInicio)
                .setParameter("horaFin", horaFin)
                .getResultList();
        return medicosList;
    }
}
