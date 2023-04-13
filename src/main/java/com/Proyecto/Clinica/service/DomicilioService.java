package com.Proyecto.Clinica.service;

import com.Proyecto.Clinica.model.Domicilio;
import com.Proyecto.Clinica.model.DomicilioDTO;
import com.Proyecto.Clinica.model.Odontologo;
import com.Proyecto.Clinica.repository.IDomicilio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DomicilioService implements IDomicilioService {

    private static final Logger logger = Logger.getLogger(DomicilioService.class);
    @Autowired
    private IDomicilio domicilioRepository;
    @Autowired
    private ObjectMapper mapper;

    private void guardarDomicilio(DomicilioDTO guardarDomicilio){
        Domicilio domicilio = mapper.convertValue(guardarDomicilio, Domicilio.class);
        domicilioRepository.save(domicilio);
        logger.info("domicilio guardado");
    }



    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
        logger.info("creando domicilio");

    }

    @Override
    public DomicilioDTO leerDomicilio(Long id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        logger.info("buscando domicilio");
        DomicilioDTO domicilioDTO = null;
        if(domicilio.isPresent())
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        return domicilioDTO;
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) {
        logger.info("modificando domicilio");
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);

    }

    @Override
    public void eliminarDomicilio(Long id) {
        logger.info("eliminando domicilio");
        domicilioRepository.deleteById(id);

    }

    @Override
    public Set<DomicilioDTO> getTodos() {
        logger.info("buscando todos los domicilios");
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domiciliosDTO = new HashSet<>();

        for(Domicilio domicilio: domicilios){
            domiciliosDTO.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        return domiciliosDTO;
    }
}
