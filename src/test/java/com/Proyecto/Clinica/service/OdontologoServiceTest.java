package com.Proyecto.Clinica.service;

import com.Proyecto.Clinica.model.OdontoloDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private IOdontologoService iodontoloservice;
    @Test
    void crearOdontoloTest() {
        OdontoloDTO odontoloDTO = new OdontoloDTO();

        odontoloDTO.setApellido("Najera");
        odontoloDTO.setNombre("Armando");
        odontoloDTO.setMatricula(1231321);
        odontoloDTO.setId(1L);

        iodontoloservice.crearOdontologo(odontoloDTO);
        Assert.assertNotNull(odontoloDTO);
    }

    @Test
    void eliminarOdontologoTest() {
        iodontoloservice.eliminarOdontologo(1L);
        Assert.assertEquals(iodontoloservice.buscarOdontologo(1L), null);
    }

}