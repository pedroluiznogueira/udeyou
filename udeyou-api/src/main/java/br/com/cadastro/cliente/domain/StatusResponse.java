package br.com.cadastro.cliente.domain;

public class StatusResponse {

    private String msg;
    private String status;
    private String tipoConta;

    public StatusResponse() {
        this.msg = "mensagem default";
        this.status = "status default";
    }

    public StatusResponse(String msg, String status) {
        this.msg = msg;
        this.status = status;
    }

    public StatusResponse(String msg, String status, String tipoConta) {
        this.msg = msg;
        this.status = status;
        this.tipoConta = tipoConta;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
