package com.Proyecto.Clinica.controller;

import com.Proyecto.Clinica.model.PacienteDTO;
import com.Proyecto.Clinica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController  {
    @Autowired
    IPacienteService pacienteService;

    @GetMapping("/listar")
    public Collection<PacienteDTO> listarPacientes(){
        return pacienteService.listarPacientes();
    }

    @PostMapping("/crear")
    public ResponseEntity<?> guardarPaciente(@RequestBody PacienteDTO paciente){
        return new ResponseEntity<PacienteDTO>(
                pacienteService.crearPaciente(paciente),
                HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPaciente(@PathVariable Long id) {
        PacienteDTO paciente = pacienteService.buscarPaciente(id);
        if(paciente != null){
            return new  ResponseEntity<PacienteDTO>(paciente, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Paciente no encontrado", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO paciente){
        PacienteDTO pacienteGuardado = pacienteService.editarPaciente(paciente);
        if(pacienteGuardado != null){
            return new  ResponseEntity<PacienteDTO>(pacienteGuardado, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Id de Paciente inexistente", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) {
        if(pacienteService.eliminarPaciente(id)) {
            return new ResponseEntity<String>("Paciente eliminado", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Paciente no encontrado", HttpStatus.NOT_FOUND);
    }
}
