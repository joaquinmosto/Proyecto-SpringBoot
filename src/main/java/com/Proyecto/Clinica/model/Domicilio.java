package com.Proyecto.Clinica.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Domicilio")
public class Domicilio {
    @Id
    @GeneratedValue
    private Long id;

    private String localidad;
    private String calle;
    private String numero;
    private String provicia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;




}
