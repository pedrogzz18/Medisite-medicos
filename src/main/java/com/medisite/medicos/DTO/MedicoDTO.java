package com.medisite.medicos.DTO;

import jakarta.persistence.Column;

import java.sql.Date;

public class MedicoDTO {
    private long idMedico;

    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private Date fechaNacimiento;

    private long idEspecialidad;

    private String email;

    private String telefono;

    private long idCiudad;

    private String colonia;

    private String domicilio;

    private String cp;
}
