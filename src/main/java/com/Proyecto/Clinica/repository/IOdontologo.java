package com.Proyecto.Clinica.repository;

import com.Proyecto.Clinica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologo extends JpaRepository<Odontologo, Long> {

}
