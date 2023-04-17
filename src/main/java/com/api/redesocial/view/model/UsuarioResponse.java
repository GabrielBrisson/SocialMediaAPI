package com.api.redesocial.view.model;

import java.util.List;

import com.api.redesocial.model.Message;
import com.api.redesocial.model.Usuario;

public class UsuarioResponse {
    private String id;
    private String name;
    private List<Message> message;
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
    public List<Message> getMessage() {
        return message;
    }
    public void setMessage(List<Message> message) {
        this.message = message;
    }
    public List<Usuario> getAmigo() {
        return amigo;
    }
    public void setAmigo(List<Usuario> amigo) {
        this.amigo = amigo;
    }
    
}
