package com.example.exampleSecon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioBO obtenerUsuario(Long id) {
        logger.info("Buscando usuario con ID: {}", id);
        UsuarioEO usuarioEO = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuarioMapper.toBO(usuarioEO);
    }
}
