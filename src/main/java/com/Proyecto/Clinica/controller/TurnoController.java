package com.Proyecto.Clinica.controller;

import com.Proyecto.Clinica.model.OdontoloDTO;
import com.Proyecto.Clinica.model.TurnoDTO;
import com.Proyecto.Clinica.service.IOdontologoService;
import com.Proyecto.Clinica.service.ITurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnosService turnoService;
    @PostMapping("/crear")
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public TurnoDTO getTurno(@PathVariable Long id){
        return  turnoService.leerTurnos(id);
    }
    @PutMapping("/modificar")
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<?> eliminarTurno(@PathVariable Long id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/eliminar/{id}")
    public Collection<TurnoDTO> getTodosTurno(){
        return turnoService.getTodos();
    }
}
