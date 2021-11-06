package com.confirmarcadastro.microservico.domain;

public class Confirmacao {

    private String msg;

    public Confirmacao() {
    }

    public Confirmacao(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
