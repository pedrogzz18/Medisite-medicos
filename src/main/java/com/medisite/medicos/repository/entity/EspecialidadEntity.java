package com.medisite.medicos.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="especialidad")
public class EspecialidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_ESPECIALIDAD")
    private long idEspecialidad;

    @Column(name="NOMBRE")
    private String nombre;
}
