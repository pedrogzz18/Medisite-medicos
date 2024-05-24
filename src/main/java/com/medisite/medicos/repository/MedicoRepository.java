package com.medisite.medicos.repository;

import com.medisite.medicos.repository.entity.MedicoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends CrudRepository<MedicoEntity, Long>, CustomizedMedicoRepository {
    public MedicoEntity findByEmail(String email);
}
