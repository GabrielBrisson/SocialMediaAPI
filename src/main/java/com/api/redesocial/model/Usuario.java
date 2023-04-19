package com.api.redesocial.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("usuarios")
public class Usuario {

    @Id
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

    public void setMessage(List<Message> mensagem) {
        this.message = mensagem;
    }

    public List<Usuario> getAmigo() {
        return amigo;
    }

    public void setAmigo(List<Usuario> amigo) {
        this.amigo = amigo;
    }    

}
