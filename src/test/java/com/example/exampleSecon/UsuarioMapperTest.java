package com.example.exampleSecon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioMapperTest {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Test
    void testMapeoEOaBO() {
        UsuarioEO usuarioEO = new UsuarioEO();
        usuarioEO.setId(1L);
        usuarioEO.setNombre("Juan");
        usuarioEO.setEdad(25);

        UsuarioBO usuarioBO = usuarioMapper.toBO(usuarioEO);

        assertNotNull(usuarioBO);
        assertEquals("Juan", usuarioBO.getName());
        assertEquals(25, usuarioBO.getEdad());
    }

    @Test
    void testMapeoBOaEO() {
        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.setId(1L);
        usuarioBO.setName("Maria");
        usuarioBO.setEdad(30);

        UsuarioEO usuarioEO = usuarioMapper.toEO(usuarioBO);

        assertNotNull(usuarioEO);
        assertEquals("Maria", usuarioEO.getName());
        assertEquals(30, usuarioEO.getEdad());
    }
}

