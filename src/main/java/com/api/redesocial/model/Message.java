package com.api.redesocial.model;

import java.time.LocalDateTime;

public class Message {

    private String value;
    private String username;
    private LocalDateTime dataCriacao;

    public String getValue() {
        return value;
    }

    public void setValue(String message) {
        this.value = message;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}