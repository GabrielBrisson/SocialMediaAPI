package com.api.redesocial.view.model;

import com.api.redesocial.model.Message;

import java.util.List;

public class ObterUsuarioResponse {

    private String id;
    private String name;
    private List<Message> message;
    private List<UsuarioResponse> amigo;

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
    public List<UsuarioResponse> getAmigo() {
        return amigo;
    }

    public void setAmigo(List<UsuarioResponse> amigo) {
        this.amigo = amigo;
    }
}
