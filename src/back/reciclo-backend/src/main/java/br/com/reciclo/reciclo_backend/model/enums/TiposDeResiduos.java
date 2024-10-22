package br.com.reciclo.reciclo_backend.model.enums;

public class TiposDeResiduos {

    private String tipo;

    TiposDeResiduos(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
