package br.com.reciclo.reciclo_backend.model;

import java.time.LocalDate;

import br.com.reciclo.reciclo_backend.model.dto.ColetaDTO;
import br.com.reciclo.reciclo_backend.model.dto.UserDetailResponseDTO;
import br.com.reciclo.reciclo_backend.model.enums.StatusColeta;
import br.com.reciclo.reciclo_backend.model.enums.TipoUsuario;
import jakarta.persistence.*;

@Entity
@Table(name = "coletas")
public class Coleta {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produtor_id", nullable = false)
    private Usuarios produtor;

    @ManyToOne
    @JoinColumn(name = "coletor_id", nullable = true)
    private Usuarios coletor;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusColeta status;

    // @OneToOne
    // @JoinColumn(name = "residuo_id", nullable = false)
    // private Residuo residuoId

    @OneToOne(mappedBy = "coleta", cascade = CascadeType.ALL)
    private Endereco endereco;

    @Column(name = "codigo_seguranca", nullable = false)
    private String codigoSeguranca;

    @Column(name = "residuo_id", nullable = false, unique = true)
    private Long residuoId;

    @Column
    private LocalDate data;

    public Coleta(Usuarios produtor, Long residuoId){
        this.produtor = produtor;
        this.coletor = null;
        this.status = StatusColeta.DISPONIVEL;
        // TODO: implementar código de segurança
        this.codigoSeguranca = "teste";
        this.residuoId = residuoId;
        this.data = LocalDate.now();
    }

    public Coleta() {}

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean requisitarColeta(Usuarios coletor){
        this.coletor = coletor;
        this.status = StatusColeta.REQUISITADO;
        return true;
    }

    public boolean aceitarDemanda(Boolean resposta) {
        if(resposta) {
            this.status = StatusColeta.TRANSITANDO;
            return true;
        }
        this.status = StatusColeta.DISPONIVEL;
        this.coletor = null;
        return false;
    }

    public ColetaDTO entregaColeta(Boolean resposta) {
        if(resposta) {
            this.status = StatusColeta.ENTREGUE;
            return this.toDTO();
        }
        this.status = StatusColeta.DISPONIVEL;
        return null;
    }

    public ColetaDTO toDTO() {
        UserDetailResponseDTO coletor = new UserDetailResponseDTO(codigoSeguranca, codigoSeguranca, codigoSeguranca, TipoUsuario.COLETOR);
        UserDetailResponseDTO produtor = new UserDetailResponseDTO(codigoSeguranca, codigoSeguranca, codigoSeguranca, TipoUsuario.PRODUTOR);
        return new ColetaDTO(id, produtor, coletor, status);
    }
}
