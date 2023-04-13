package com.Proyecto.Clinica.service;

import com.Proyecto.Clinica.model.TurnoDTO;

import java.util.Set;

public interface ITurnosService {
    void crearTurno(TurnoDTO turnoDTO);
    TurnoDTO leerTurnos(Long id);
    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);
    Set<TurnoDTO> getTodos();
}
