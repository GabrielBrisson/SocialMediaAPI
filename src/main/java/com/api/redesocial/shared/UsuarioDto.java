package com.api.redesocial.shared;

import java.util.List;

import com.api.redesocial.model.Usuario;

public class UsuarioDto {
  
    private String id;
    private String name;
    private List<Usuario> amigo;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Usuario> getAmigo() {
        return amigo;
    }
    public void setAmigo(List<Usuario> amigo) {
        this.amigo = amigo;
    }
}
