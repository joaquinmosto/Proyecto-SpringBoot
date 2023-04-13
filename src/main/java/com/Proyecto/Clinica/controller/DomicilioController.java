package com.Proyecto.Clinica.controller;

import com.Proyecto.Clinica.model.DomicilioDTO;
import com.Proyecto.Clinica.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    IDomicilioService domicilioService;

    public ResponseEntity<?> CrearDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.crearDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public DomicilioDTO getdomicilio(@PathVariable Long id){return domicilioService.leerDomicilio(id);}
    @PutMapping("/modificar")
    public ResponseEntity<?> modificarDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.modificarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarDomicilios(@PathVariable Long id){
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/listar")
    public Collection<DomicilioDTO> getTodosDomicilios(){
        return domicilioService.getTodos();
    }
}
