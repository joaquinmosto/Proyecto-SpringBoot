package com.Proyecto.Clinica.repository;

import com.Proyecto.Clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaciente extends JpaRepository<Paciente, Long> {

}
