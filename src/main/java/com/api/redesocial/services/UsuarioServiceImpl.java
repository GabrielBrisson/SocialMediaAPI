package com.api.redesocial.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.redesocial.model.Usuario;
import com.api.redesocial.repository.UsuarioRepositorio;
import com.api.redesocial.shared.UsuarioDto;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepositorio repository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public List<UsuarioDto> obterTodosUsuarios() {
        List<Usuario> usuarios = repository.findAll();

        return usuarios.stream()
                .map(usuario -> mapper.map(usuario, UsuarioDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioDto> obterPorId(String id) {
        Optional<Usuario> usuarioOpt = repository.findById(id);

        if (usuarioOpt.isPresent()) {
            UsuarioDto usuarioDto = mapper.map(usuarioOpt.get(), UsuarioDto.class);
            return Optional.of(usuarioDto);
        }

        return Optional.empty();
    }

    @Override
    public UsuarioDto inserirUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = mapper.map(usuarioDto, Usuario.class);
        Usuario usuarioInserido = repository.insert(usuario);

        return mapper.map(usuarioInserido, UsuarioDto.class);
    }

    @Override
    public UsuarioDto atualizarUsuario(String id, UsuarioDto usuarioDto) {
        Usuario usuario = mapper.map(usuarioDto, Usuario.class);
        usuario.setId(id);
        Usuario atualizarUsuario = repository.save(usuario);

        return mapper.map(atualizarUsuario, UsuarioDto.class);
    }

    @Override
    public Boolean realizarAmizade(String id1, String id2) {
        Optional<UsuarioDto> user1Dto = obterPorId(id1);
        Optional<UsuarioDto> user2Dto = obterPorId(id2);
        Usuario user1 = mapper.map(user1Dto.get(), Usuario.class);
        Usuario user2 = mapper.map(user2Dto.get(), Usuario.class);

        if (user1.getAmigo() == null) {
            user1.setAmigo(new ArrayList<Usuario>());
        }
        if (user2.getAmigo() == null) {
            user2.setAmigo(new ArrayList<Usuario>());
        }
        boolean existe = false;
        for (Usuario u : user1.getAmigo()) {
            if (u.getId().equals(id2)) {
                existe = true;
            }
        }

        if (!existe) {
            Usuario amigoUser1 = new Usuario();
            amigoUser1.setId(user2.getId());
            amigoUser1.setName(user2.getName());

            Usuario amigoUser2 = new Usuario();
            amigoUser2.setId(user1.getId());
            amigoUser2.setName(user1.getName());

            user1.getAmigo().add(amigoUser1);
            user2.getAmigo().add(amigoUser2);

            repository.save(user1);
            repository.save(user2);
        }

        return existe;
    }

    @Override
    public List<UsuarioDto> consultarAmizade(String id) {
        Optional<UsuarioDto> usuarioDto = obterPorId(id);
        Usuario usuario = mapper.map(usuarioDto.get(), Usuario.class);
        List<Usuario> amigos = usuario.getAmigo();

        return amigos.stream()
                .map(u -> mapper.map(u, UsuarioDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removerAmizade(String idUsuario, String idRemocao) {
        Optional<Usuario> usuarioOpt1 = repository.findById(idUsuario);
        Optional<Usuario> usuarioOpt2 = repository.findById(idRemocao);

        if (usuarioOpt1.isPresent() && usuarioOpt2.isPresent()) {
            Usuario usuario1 = usuarioOpt1.get();
            Usuario usuario2 = usuarioOpt2.get();

            usuario1.getAmigo().removeIf(amigo -> amigo.getId().equals(idRemocao));
            usuario2.getAmigo().removeIf(amigo -> amigo.getId().equals(idUsuario));

            repository.save(usuario1);
            repository.save(usuario2);
        }

    }

    @Override
    public void removerUsuario(String id) {
        repository.deleteById(id);
    }
    
}