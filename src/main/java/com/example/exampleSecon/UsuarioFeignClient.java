package com.example.exampleSecon;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service", url = "http://localhost:8090")
public interface UsuarioFeignClient {
    @GetMapping("/data/{id}")
    UsuarioBO obtenerUsuario(@PathVariable Long id);
}
