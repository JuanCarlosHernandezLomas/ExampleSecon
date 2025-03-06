package com.example.exampleSecon;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsuarioFeignClientTest {

    @Mock
    private UsuarioFeignClient usuarioFeignClient;

    @Test
    void testObtenerUsuarioFeign() {
        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.setId(1L);
        usuarioBO.setName("Juan");
        usuarioBO.setEdad(25);

        Mockito.when(usuarioFeignClient.obtenerUsuario(1L)).thenReturn(usuarioBO);

        UsuarioBO resultado = usuarioFeignClient.obtenerUsuario(1L);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getName());
        assertEquals(25, resultado.getEdad());
    }
}