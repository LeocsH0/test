package br.com.reciclo.reciclo_backend.model;

import java.util.Objects;

import br.com.reciclo.reciclo_backend.model.enums.TiposDeResiduos;
import jakarta.persistence.*;

@Entity
@Table(name = "residuos")
public class Residuos {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private TiposDeResiduos tipo;

    @Column
    private String descricao;

    @Column
    private Integer quantidade;

    @Column
    private String unidades;


    public Residuos() {
    }

    public Residuos(TiposDeResiduos tipo, Integer quantidade, String unidades, String descricao) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.unidades = unidades;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("tipo: ");
        sb.append(tipo);
        sb.append("\nunidades: ");
        sb.append(unidades);
        sb.append("\ndescricao: ");
        sb.append(descricao);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Residuos residuo = (Residuos) obj;
        return tipo.equals(residuo.tipo) &&
                quantidade.equals(residuo.quantidade) &&
                unidades.equals(residuo.unidades) &&
                descricao.equals(residuo.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, quantidade, unidades, descricao);
    }

    private boolean ValidaQuantidades(){
        return false;
    }

    private boolean ValidaTipos(){
        return false;
    }

    private boolean ValidaUnidades(){
        return false;
    }

    public TiposDeResiduos getTipo(){
        return this.tipo;
    }
    
    public Integer getQuantidades(){
        return this.quantidade;
    }

    public String getUnidades(){
        return this.unidades;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public Long getId() {
        return id;
    }
}




