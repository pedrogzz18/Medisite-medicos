package com.medisite.medicos.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name="medico")
public class MedicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_medico")
    private long idMedico;
    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido_paterno")
    private String apellidoPaterno;

    @Column(name="apellido_materno")
    private String apellidoMaterno;

    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name="id_especialidad")
    private long idEspecialidad;

    @Column(name="email")
    private String email;

    @Column(name="telefono")
    private String telefono;

    @Column(name="contraseña")
    private String contraseña;

    @Column(name="id_ciudad")
    private long idCiudad;

    @Column(name="colonia")
    private String colonia;

    @Column(name="domicilio")
    private String domicilio;

    @Column(name="cp")
    private String cp;

}
