package com.example.exampleSecon;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioMapper usuarioMapper;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Test
    void testObtenerUsuario_UsuarioExiste() {
        UsuarioEO usuarioEO = new UsuarioEO();
        usuarioEO.setId(1L);
        usuarioEO.setNombre("Juan");
        usuarioEO.setEdad(25);

        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.setId(1L);
        usuarioBO.setName("Juan");
        usuarioBO.setEdad(25);

        Mockito.when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuarioEO));
        Mockito.when(usuarioMapper.toBO(usuarioEO)).thenReturn(usuarioBO);

        UsuarioBO resultado = usuarioService.obtenerUsuario(1L);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getName());
        assertEquals(25, resultado.getEdad());
    }

    @Test
    void testObtenerUsuario_UsuarioNoExiste() {
        Mockito.when(usuarioRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            usuarioService.obtenerUsuario(1L);
        });

        assertEquals("Usuario no encontrado", exception.getMessage());
    }
}
