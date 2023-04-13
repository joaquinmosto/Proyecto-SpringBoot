package com.Proyecto.Clinica.service;

import com.Proyecto.Clinica.model.DomicilioDTO;

import java.util.Collection;
import java.util.Set;

public interface IDomicilioService {
    void crearDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO leerDomicilio(Long id);
    void modificarDomicilio(DomicilioDTO domicilioDTO);
    void eliminarDomicilio(Long id);
    Set<DomicilioDTO> getTodos();
}
