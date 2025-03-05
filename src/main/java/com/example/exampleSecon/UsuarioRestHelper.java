package com.example.exampleSecon;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UsuarioRestHelper {
    private final RestTemplate restTemplate;

    public UsuarioRestHelper(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public UsuarioBO obtenerUsuario(Long id) {
        return restTemplate.getForObject("http://localhost:8090/api/data/" + id, UsuarioBO.class);
    }
}
