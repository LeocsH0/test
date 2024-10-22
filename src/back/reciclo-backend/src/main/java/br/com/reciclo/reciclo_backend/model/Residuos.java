package br.com.reciclo.reciclo_backend.model;

import java.util.Objects;

import br.com.reciclo.reciclo_backend.model.enums.TiposDeResiduos;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "residuos")
public class Residuos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private TiposDeResiduos tipo;
    private String descricao; 
    private Integer quantidade;
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

    }

    private boolean ValidaTipos(){

    }

    private boolean ValidaUnidades(){

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
}




