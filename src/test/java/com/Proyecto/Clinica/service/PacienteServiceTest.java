package com.Proyecto.Clinica.service;

import com.Proyecto.Clinica.model.PacienteDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PacienteServiceTest {
    @Autowired
    private IPacienteService iPacienteService;
    @Test
    void crearPacienteTest(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("perez");
        pacienteDTO.setNombre("juan");
        pacienteDTO.setDni(34234);
        pacienteDTO.getFecha_ingreso();
        pacienteDTO.setId(2L);

        iPacienteService.crearPaciente(pacienteDTO);
        Assert.assertNotNull(pacienteDTO);

    }

    @Test
    void eliminarPacienteTest(){
        iPacienteService.eliminarPaciente(1L);
        Assert.assertEquals(iPacienteService.buscarPaciente(1L), null);
    }
}
