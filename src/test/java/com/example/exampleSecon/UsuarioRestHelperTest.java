package com.example.exampleSecon;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
public class UsuarioRestHelperTest {

    @Autowired
    private UsuarioRestHelper usuarioRestHelper;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    private MockRestServiceServer mockServer;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    void testObtenerUsuario() throws Exception {
        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.setId(1L);
        usuarioBO.setName("Juan");
        usuarioBO.setEdad(25);

        mockServer.expect(requestTo("http://localhost:8090/api/data/1"))
                .andRespond(withSuccess(objectMapper.writeValueAsString(usuarioBO), MediaType.APPLICATION_JSON));

        UsuarioBO resultado = usuarioRestHelper.obtenerUsuario(1L);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getName());
        assertEquals(25, resultado.getEdad());
    }
}
