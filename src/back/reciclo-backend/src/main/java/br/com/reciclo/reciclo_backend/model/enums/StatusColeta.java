package br.com.reciclo.reciclo_backend.model.enums;

public enum StatusColeta {
    DISPONIVEL("disponivel"),
    REQUISITADO("requisitado"),
    TRANSITANDO("transitando"),
    ENTREGUE("entregue");

    private String status;

    StatusColeta(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
