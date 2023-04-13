package com.Proyecto.Clinica.service;


import com.Proyecto.Clinica.model.Paciente;
import com.Proyecto.Clinica.model.PacienteDTO;

import com.Proyecto.Clinica.repository.IPaciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService {
    private static final Logger logger = Logger.getLogger(PacienteService.class);
    @Autowired
    private IPaciente pacienteRepository;
    @Autowired
    private ObjectMapper mapper;


    @Override
    public PacienteDTO crearPaciente(PacienteDTO paciente) {
        paciente.setId(0L);
        logger.info("Creando paciente: " + paciente);
        Paciente pacienteGuardado = pacienteRepository.save(mapper.convertValue(paciente, Paciente.class));
        paciente.setId(paciente.getId());
        logger.info("Paciente creado: " + pacienteGuardado);
        return mapper.convertValue(pacienteGuardado, PacienteDTO.class);
    }


    @Override
    public PacienteDTO buscarPaciente(Long id) {
        logger.info("Buscando paciente con ID: " + id);
        Optional<Paciente> o = pacienteRepository.findById(id);
        if(o.isPresent()){
            logger.info("Paciente con ID: " + id + " encontrado.");
            return mapper.convertValue(o, PacienteDTO.class);
        }
        logger.info("Paciente con ID: " + id + " no encontrado.");
        return null;
    }


    @Override
    public PacienteDTO editarPaciente(PacienteDTO paciente) {
        logger.info("Editando Paciente: "+ paciente);
        if(buscarPaciente(paciente.getId()) != null) {
            Paciente guardado = pacienteRepository.save(mapper.convertValue(paciente, Paciente.class));
            logger.info("Editado Paciente: "+ guardado);
            return mapper.convertValue(guardado,PacienteDTO.class);
        }
        return null;
    }


    @Override
    public boolean eliminarPaciente(Long id) {
        logger.info("Eliminando paciente con ID: " + id);
        if(buscarPaciente(id) !=null){
            pacienteRepository.deleteById(id);
            logger.info("Paciente con ID: " + id + " eliminando.");
            return true;
        }
        return false;
    }


    @Override
    public Collection<PacienteDTO> listarPacientes() {
        logger.info("Creando lista de pacientes...");
        List<Paciente> pacienteList = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente o:pacienteList) {
            pacientesDTO.add(mapper.convertValue(o, PacienteDTO.class));
        }
        logger.info("Lista de pacientes creada.");
        return pacientesDTO;
    }

}
