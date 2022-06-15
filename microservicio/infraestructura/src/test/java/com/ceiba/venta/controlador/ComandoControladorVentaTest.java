package com.ceiba.venta.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.factura.controlador.ComandoControladorFactura;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;
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

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorFactura.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorVentaTest{

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioVenta repositorioVenta;

    @Test
    void crearVentaExitosa() throws Exception{
        var comandoRegistrarVentaTestDataBuilder=new ComandoRegistrarVentaTestDataBuilder().crearPorDefecto().build();
        var resultado = mocMvc.perform(post("/venta")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoRegistrarVentaTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaVenta.class);

        var ventaGuardada = repositorioVenta.obtener(respuesta.getValor());

        Assertions.assertEquals(2l, ventaGuardada.getIdArticulo());
        Assertions.assertEquals(10, ventaGuardada.getCantidadVenta());
        Assertions.assertEquals(BigDecimal.valueOf(1222), ventaGuardada.getPrecioVenta());

    }
}
