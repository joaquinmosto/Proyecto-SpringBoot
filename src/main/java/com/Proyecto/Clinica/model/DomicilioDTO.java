package com.Proyecto.Clinica.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DomicilioDTO {
    private Long id;

    private String localidad;
    private String calle;
    private String numero;
    private String provicia;
    private Paciente paciente;
}
