package com.Proyecto.Clinica.service;

import com.Proyecto.Clinica.model.Paciente;
import com.Proyecto.Clinica.model.PacienteDTO;
import com.Proyecto.Clinica.model.Turno;
import com.Proyecto.Clinica.model.TurnoDTO;
import com.Proyecto.Clinica.repository.IPaciente;
import com.Proyecto.Clinica.repository.ITurno;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnosService{
    private static final Logger logger = Logger.getLogger(TurnoService.class);

    @Autowired
    private ITurno turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
        logger.info("creando turno");
    }

    @Override
    public TurnoDTO leerTurnos(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        logger.info("buscando turno");
        if (turno.isPresent())
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        return turnoDTO;
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        logger.info("modificando turno");
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
        logger.info("eliminando turno");

    }

    @Override
    public Set<TurnoDTO> getTodos() {
        List<Turno> turnos =turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        logger.info("buscando todos los turnos");

        for (Turno turno: turnos){
            turnosDTO.add(mapper.convertValue(turnos, TurnoDTO.class));
        }
        return turnosDTO;
    }
}
