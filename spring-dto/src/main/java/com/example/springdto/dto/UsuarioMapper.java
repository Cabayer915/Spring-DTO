package com.example.springdto.dto;

import com.example.springdto.controller.UsuarioController;
import com.example.springdto.entity.Usuario;

import java.util.List;
import java.util.Objects;

public class UsuarioMapper {
    public static UsuarioConsultaDto toDto(Usuario usuario){
        if (Objects.isNull(usuario)) {
            return null;
        }

        UsuarioConsultaDto dto = new UsuarioConsultaDto();

        dto.setId(usuario.getId());
        dto.setNomeCompleto(usuario.getNome());
        dto.setEnderecoEmail(usuario.getEmail());
        dto.setAtivo(usuario.getAtivo());

        return dto;
    }

    public static List<UsuarioConsultaDto> toDto(List<Usuario> usuario) {
        return usuario.stream()
                .map(UsuarioMapper::toDto)
                .toList();
    }
}
