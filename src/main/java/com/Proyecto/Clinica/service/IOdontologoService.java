package com.Proyecto.Clinica.service;

import com.Proyecto.Clinica.model.OdontoloDTO;

import java.util.Collection;


public interface IOdontologoService {
    public OdontoloDTO crearOdontologo(OdontoloDTO odontologo);
     OdontoloDTO buscarOdontologo(Long id);
    public OdontoloDTO editarOdontologo(OdontoloDTO odontologo);
    public boolean eliminarOdontologo(Long id);
    Collection<OdontoloDTO> listarOdontologos();
}


