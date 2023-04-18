package com.api.redesocial.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.redesocial.model.Usuario;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String> { }
