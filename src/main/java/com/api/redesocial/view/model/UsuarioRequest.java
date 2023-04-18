package com.api.redesocial.view.model;

import java.util.List;

import com.api.redesocial.model.Usuario;

public class UsuarioRequest {

    private String name;
    private List<Usuario> amigo;
    private String profilePicture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<Usuario> getAmigo() {
        return amigo;
    }

    public void setAmigo(List<Usuario> amigo) {
        this.amigo = amigo;
    }
    
}
