package com.example.springdto.controller;

import com.example.springdto.dto.UsuarioConsultaDto;
import com.example.springdto.dto.UsuarioMapper;
import com.example.springdto.entity.Usuario;
import com.example.springdto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<UsuarioConsultaDto>> listarTodos(){
        List<Usuario> todosUsuarios = this.repository.findAll();

        if (todosUsuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        List<UsuarioConsultaDto> dto = UsuarioMapper.toDto(todosUsuarios);

        return ResponseEntity.status(200).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioConsultaDto> buscarPorId(@PathVariable int id) {
        Optional<Usuario> byId = this.repository.findById(id);

        if (byId.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        UsuarioConsultaDto dto = UsuarioMapper.toDto(byId.get());
        return ResponseEntity.status(200).body(dto);
    }
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario novoUsuario) {
        Usuario usuarioCadastrado = this.repository.save(novoUsuario);
        return ResponseEntity.status(201).body(usuarioCadastrado);
    }
}
