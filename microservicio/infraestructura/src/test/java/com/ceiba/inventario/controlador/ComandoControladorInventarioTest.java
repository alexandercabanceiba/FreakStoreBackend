package com.ceiba.inventario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.factura.controlador.ComandoControladorFactura;
import com.ceiba.inventario.puerto.repositorio.RepositorioInventario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorFactura.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorInventarioTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioInventario repositorioInventario;

    @Test
    void crearInventarioExitoso() throws Exception {

        var comandoRegistrarInventarioTestDataBuilder = new ComandoRegistrarInventarioTestDataBuilder().crearPorDefecto().build();

        var resultado = mocMvc.perform(post("/inventario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoRegistrarInventarioTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        var inventarioGuardado = repositorioInventario.obtenerPorIdArticulo(comandoRegistrarInventarioTestDataBuilder.getIdArticulo());

        Assertions.assertEquals(2l, inventarioGuardado.getId());
        Assertions.assertEquals(400, inventarioGuardado.getCantidad());
    }
}
