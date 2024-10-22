package br.com.reciclo.reciclo_backend.model.enums;

public enum TiposDeResiduos {
    METAL("metal"),
    PLASTICO("plastico"),
    PAPEL("papel"),
    VIDRO("vidro");

    private String tipo;

    TiposDeResiduos(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}

