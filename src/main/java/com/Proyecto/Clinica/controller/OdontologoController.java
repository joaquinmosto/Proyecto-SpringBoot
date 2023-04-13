package com.Proyecto.Clinica.controller;


import com.Proyecto.Clinica.model.OdontoloDTO;
import com.Proyecto.Clinica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    IOdontologoService odontologoService;
    @PostMapping("/crear")
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontoloDTO odontoloDTO){
        return new ResponseEntity<OdontoloDTO>(
                odontologoService.crearOdontologo(odontoloDTO),
                HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public OdontoloDTO getOdontologo(@PathVariable Long id){
        return  odontologoService.buscarOdontologo(id);
    }
    @PutMapping("/modificar")
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontoloDTO odontoloDTO){
        odontologoService.editarOdontologo(odontoloDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/listar")
    public Collection<OdontoloDTO> getTodosOdontologos(){
        return odontologoService.listarOdontologos();
    }
}