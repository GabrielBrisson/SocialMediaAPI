package com.api.redesocial.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("usuarios")
public class Usuario {

    @Id
    private String id;
    private String name;
    private String profilePicture;

    private List<Usuario> amigos;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Usuario> getAmigo() {
        return amigos;
    }
    public void setAmigo(List<Usuario> amigos) {
        this.amigos = amigos;
    }
    
}
