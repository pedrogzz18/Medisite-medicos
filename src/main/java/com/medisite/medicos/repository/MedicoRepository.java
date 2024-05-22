package com.medisite.medicos.repository;

import com.medisite.medicos.repository.entity.MedicoEntity;
import org.springframework.data.repository.CrudRepository;

public interface MedicoRepository extends CrudRepository<MedicoEntity, Long> {
}
