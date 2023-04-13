package com.Proyecto.Clinica.repository;

import com.Proyecto.Clinica.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurno extends JpaRepository<Turno, Long> {
}
