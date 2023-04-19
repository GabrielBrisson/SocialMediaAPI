package com.api.redesocial.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.api.redesocial.model.Usuario;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{
    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    List<Usuario> findByNomeContaining(String nome);
}
