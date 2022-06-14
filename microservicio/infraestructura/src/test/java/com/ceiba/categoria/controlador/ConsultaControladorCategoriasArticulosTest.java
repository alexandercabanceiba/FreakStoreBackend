package com.ceiba.categoria.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.factura.controlador.ConsultaControladorFactura;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorFactura.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorCategoriasArticulosTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    void consultarCategoriasDeArticulos() throws Exception {
        mocMvc.perform(get("/articulo/obtener-articulos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].idCategoria", is(1)))
                .andExpect(jsonPath("$[0].descripcion", is("PRODUCTO PRUEBA 1")))
                .andExpect(jsonPath("$[0].precio", is(150000)));
    }
}
