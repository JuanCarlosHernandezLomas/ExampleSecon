package com.example.exampleSecon;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioBO toBO(UsuarioEO usuarioEO);
    UsuarioEO toEO(UsuarioBO usuarioBO);
}
