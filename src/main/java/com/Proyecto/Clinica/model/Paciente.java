package com.Proyecto.Clinica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
    private Date fecha_ingreso;
    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Domicilio>domicilios;


}

