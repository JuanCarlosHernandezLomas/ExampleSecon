package com.example.exampleSecon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final UsuarioFeignClient usuarioFeignClient;
    private final UsuarioRestHelper usuarioRestHelper;
    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    public UsuarioController(UsuarioService usuarioService, UsuarioFeignClient usuarioFeignClient, UsuarioRestHelper usuarioRestHelper) {
        this.usuarioService = usuarioService;
        this.usuarioFeignClient = usuarioFeignClient;
        this.usuarioRestHelper = usuarioRestHelper;
    }

    @GetMapping("/{id}/rest")
    public ResponseEntity<UsuarioBO> obtenerUsuarioRest(@PathVariable Long id) {
        logger.info("Llamando a usuario con RestTemplate");
        return ResponseEntity.ok(usuarioRestHelper.obtenerUsuario(id));
    }

    @GetMapping("/{id}/feign")
    public ResponseEntity<UsuarioBO> obtenerUsuarioFeign(@PathVariable Long id) {
        logger.info("Llamando a usuario con Feign");
        return ResponseEntity.ok(usuarioFeignClient.obtenerUsuario(id));
    }
}
