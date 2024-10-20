package br.com.reciclo.reciclo_backend.model.enums;

public enum TipoUsuario {
    ADMIN("admin"),
    PRODUTOR("produtor"),
    COLETOR("coletor");

    private String tipo;

    TipoUsuario(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
