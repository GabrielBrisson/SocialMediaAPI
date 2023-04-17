package com.api.redesocial.services;

import java.util.List;
import java.util.Optional;

import com.api.redesocial.shared.UsuarioDto;

public interface UsuarioService {
    List<UsuarioDto> obterTodosUsuarios();
    Optional<UsuarioDto> obterPorId(String id);
    UsuarioDto inserirUsuario(UsuarioDto usuarioDto);
    void realizarAmizade(String id1, String id2);
    List<UsuarioDto> consultarAmizade(String id);
    void removerAmizade(String idUsuario, String idRemocao);
    void removerUsuario(String id);
}