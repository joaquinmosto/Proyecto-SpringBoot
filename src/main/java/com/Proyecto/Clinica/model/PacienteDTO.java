package com.Proyecto.Clinica.model;

import lombok.*;

import java.util.Date;

@Data
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
    private Date fecha_ingreso;
}
