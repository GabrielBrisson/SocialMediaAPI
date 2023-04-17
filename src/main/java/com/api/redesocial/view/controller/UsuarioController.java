package com.api.redesocial.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.redesocial.services.UsuarioService;
import com.api.redesocial.shared.UsuarioDto;
import com.api.redesocial.view.model.UsuarioAlteracao;
import com.api.redesocial.view.model.UsuarioRequest;
import com.api.redesocial.view.model.UsuarioResponse;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService userService;

    ModelMapper mapper = new ModelMapper();

    @GetMapping(value = "/obterTodosUsuarios")  
    public ResponseEntity<List<UsuarioResponse>> getAllUsers() {
        List<UsuarioDto> users = userService.obterTodosUsuarios();
        List<UsuarioResponse> response = users.stream()
        .map(u -> mapper.map(u, UsuarioResponse.class))
        .collect(Collectors.toList());
        

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/obterPorId/{id}")
    public ResponseEntity<UsuarioResponse> getUserById(@PathVariable String id) {
        Optional<UsuarioDto> userDto = userService.obterPorId(id);

        if (userDto.isPresent()) {
            UsuarioResponse response = mapper.map(userDto.get(), UsuarioResponse.class);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/consultarAmizade/{id}")
    public ResponseEntity<List<UsuarioResponse>> consultarAmizade(@PathVariable String id) {
        List<UsuarioDto> usuario = userService.consultarAmizade(id);
        List<UsuarioResponse> response = usuario.stream()
        .map(u -> mapper.map(u, UsuarioResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/registrarUsuario")
    public ResponseEntity<UsuarioResponse> registrarUsuario(@RequestBody UsuarioRequest request) {
        UsuarioDto usuarioDto = mapper.map(request, UsuarioDto.class);
        UsuarioDto usuarioCadastrado = userService.inserirUsuario(usuarioDto);

        return new ResponseEntity<>(mapper.map(usuarioCadastrado, UsuarioResponse.class), HttpStatus.CREATED);
    }

    @PutMapping(value = "/atualizarUsuario/{id}")
    public ResponseEntity<UsuarioResponse> atualizarUsuario(@PathVariable String id, @RequestBody UsuarioAlteracao usuario) {
        UsuarioDto dto = mapper.map(usuario, UsuarioDto.class);
        UsuarioDto usuarioAtualizado = userService.atualizarUsuario(id, dto);

        return new ResponseEntity<>(mapper.map(usuarioAtualizado, UsuarioResponse.class), HttpStatus.OK);
    }

    @PutMapping(value = "/realizarAmizade/{id1}/{id2}")
    public ResponseEntity<Void> realizarAmizade(@PathVariable String id1, @PathVariable String id2) {
        boolean existe = userService.realizarAmizade(id1, id2);

        if (existe) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/removerAmizade/{idUsuario}/{idRemocao}")
    public ResponseEntity<Void> removerAmizade(@PathVariable String idUsuario, @PathVariable String idRemocao) {
        userService.removerAmizade(idUsuario, idRemocao);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/removerUsuario/{idUsuario}")
    public ResponseEntity<String> removerUsuario(@PathVariable String idUsuario) {
        userService.removerUsuario(idUsuario);

        return new ResponseEntity<>("Usuario deletado com sucesso!", HttpStatus.OK);
    }
    
}
