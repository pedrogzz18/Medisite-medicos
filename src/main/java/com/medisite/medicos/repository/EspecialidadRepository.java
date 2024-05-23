package com.medisite.medicos.repository;

import com.medisite.medicos.repository.entity.EspecialidadEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends CrudRepository<EspecialidadEntity, Long> {
}
