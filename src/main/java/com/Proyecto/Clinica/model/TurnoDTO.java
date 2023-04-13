package com.Proyecto.Clinica.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class TurnoDTO {

    private Long id;
    private LocalDate fechaHora;
    private Odontologo odontologo;
    private Paciente paciente;
}
