package com.Proyecto.Clinica.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class OdontoloDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private int matricula;
}
