package com.Proyecto.Clinica.service;

import com.Proyecto.Clinica.model.OdontoloDTO;
import com.Proyecto.Clinica.model.PacienteDTO;

import java.util.Collection;
import java.util.Set;

public interface IPacienteService {
    public PacienteDTO crearPaciente(PacienteDTO paciente);
    PacienteDTO buscarPaciente(Long id);
    public PacienteDTO editarPaciente(PacienteDTO paciente);
    public boolean eliminarPaciente(Long id);
    Collection<PacienteDTO> listarPacientes();
}