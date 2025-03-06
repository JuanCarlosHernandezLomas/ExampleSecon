package com.example.exampleSecon;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @MockBean
    private UsuarioFeignClient usuarioFeignClient;

    @MockBean
    private UsuarioRestHelper usuarioRestHelper;

    @Test
    void testObtenerUsuarioRest() throws Exception {
        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.setId(1L);
        usuarioBO.setName("Juan");
        usuarioBO.setEdad(25);

        Mockito.when(usuarioRestHelper.obtenerUsuario(1L)).thenReturn(usuarioBO);

        mockMvc.perform(get("/data/1/rest"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Juan"))
                .andExpect(jsonPath("$.edad").value(25));
    }

    @Test
    void testObtenerUsuarioFeign() throws Exception {
        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.setId(1L);
        usuarioBO.setName("Juan");
        usuarioBO.setEdad(25);

        Mockito.when(usuarioFeignClient.obtenerUsuario(1L)).thenReturn(usuarioBO);

        mockMvc.perform(get("/data/1/feign"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Juan"))
                .andExpect(jsonPath("$.edad").value(25));
    }
}
