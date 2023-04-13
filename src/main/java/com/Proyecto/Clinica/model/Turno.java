package com.Proyecto.Clinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Turno")
@Entity
public class Turno {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate fechaHora;

    @ManyToOne
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;
}
