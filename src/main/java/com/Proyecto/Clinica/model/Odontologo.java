package com.Proyecto.Clinica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Odontologo")
public class Odontologo {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellido;
    private int matricula;
    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnos;








}

