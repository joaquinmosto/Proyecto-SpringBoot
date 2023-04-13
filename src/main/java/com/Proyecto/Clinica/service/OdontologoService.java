package com.Proyecto.Clinica.service;


import com.Proyecto.Clinica.model.OdontoloDTO;
import com.Proyecto.Clinica.model.Odontologo;
import com.Proyecto.Clinica.repository.IOdontologo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements  IOdontologoService{

    private static final Logger logger = Logger.getLogger(OdontologoService.class);
    @Autowired
    private IOdontologo odontologoRepository;
    @Autowired
    private ObjectMapper mapper;


    @Override
    public OdontoloDTO crearOdontologo(OdontoloDTO odontologo) {
        odontologo.setId(0L);
        logger.info("Creando odontologo: " + odontologo);
        Odontologo odontologoGuardado = odontologoRepository.save(mapper.convertValue(odontologo, Odontologo.class));
        odontologo.setId(odontologo.getId());
        logger.info("Odontologo creado: " + odontologoGuardado);
        return mapper.convertValue(odontologoGuardado, OdontoloDTO.class);
    }


    @Override
    public OdontoloDTO buscarOdontologo(Long id) {
        logger.info("Buscando odontologo con ID: " + id);
        Optional<Odontologo> o = odontologoRepository.findById(id);
        if(o.isPresent()){
            logger.info("Odontologo con ID: " + id + " encontrado.");
            return mapper.convertValue(o, OdontoloDTO.class);
        }
        logger.info("Odontologo con ID: " + id + " no encontrado.");
        return null;
    }


    @Override
    public OdontoloDTO editarOdontologo(OdontoloDTO odontologo) {
        logger.info("Editando Odontologo: "+ odontologo);
        if(buscarOdontologo(odontologo.getId()) != null) {
            Odontologo guardado = odontologoRepository.save(mapper.convertValue(odontologo, Odontologo.class));
            logger.info("Editado Odontologo: "+ guardado);
            return mapper.convertValue(guardado,OdontoloDTO.class);
        }
        return null;
    }


    @Override
    public boolean eliminarOdontologo(Long id) {
        logger.info("Eliminando odontologo con ID: " + id);
        if(buscarOdontologo(id) !=null){
            odontologoRepository.deleteById(id);
            logger.info("Odontologo con ID: " + id + " eliminando.");
            return true;
        }
        return false;
    }


    @Override
    public Collection<OdontoloDTO> listarOdontologos() {
        logger.info("Creando lista de odontologos...");
        List<Odontologo> odontologoList = odontologoRepository.findAll();
        Set<OdontoloDTO> odontologosDTO = new HashSet<>();
        for (Odontologo o:odontologoList) {
            odontologosDTO.add(mapper.convertValue(o, OdontoloDTO.class));
        }
        logger.info("Lista de odontologos creada.");
        return odontologosDTO;
    }
}

