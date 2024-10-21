package br.com.reciclo.reciclo_backend.model;

import br.com.reciclo.reciclo_backend.model.dto.EnderecoDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "coleta_id")
    private Coleta coleta;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco() {
    }

    public Endereco(Coleta coleta, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String cep) {
        this.coleta = coleta;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public EnderecoDTO gerarDTO() {
        return new EnderecoDTO(coleta.toDTO(), logradouro, numero, complemento, bairro, cidade, estado, cep);
    }
}
