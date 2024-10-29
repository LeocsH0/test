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

    public static StatusColeta fromValue(String value) {
        for (StatusColeta status : StatusColeta.values()) {
            if (status.getStatus().equalsIgnoreCase(value)) {
                return status;
            }
        }

        throw new IllegalArgumentException("Status inválido: " + value);
    }
}
