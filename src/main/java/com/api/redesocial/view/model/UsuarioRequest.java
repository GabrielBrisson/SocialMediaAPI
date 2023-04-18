package com.api.redesocial.view.model;

import java.util.ArrayList;
import java.util.List;

import com.api.redesocial.model.Message;
import com.api.redesocial.model.Usuario;

public class UsuarioRequest {

    private String name = "";
    private List<Usuario> amigo = new ArrayList<>();
    private List<Message> message = new ArrayList<>();

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

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
