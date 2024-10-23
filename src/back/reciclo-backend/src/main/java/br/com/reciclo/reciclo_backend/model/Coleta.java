package br.com.reciclo.reciclo_backend.model;

import java.security.SecureRandom;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", nullable = true)
    private Endereco endereco;

    @Column(name = "codigo_seguranca", nullable = false)
    private String codigoSeguranca;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "residuo_id", nullable = false)
    private Residuos residuo;

    @Column
    private LocalDate data;

    private static final int TAMANHO_CODIGO_SEGURANCA = 4;

    public Coleta(Usuarios produtor, Residuos residuo, Endereco endereco) {
        this.produtor = produtor;
        this.coletor = null;
        this.status = StatusColeta.DISPONIVEL;
        this.codigoSeguranca = this.gerarCodigoSeguranca();
        this.residuo = residuo;
        this.data = LocalDate.now();
        this.endereco = endereco;
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
        return new ColetaDTO(id, status);
    }

    private String gerarCodigoSeguranca() {
        StringBuilder codigo = new StringBuilder(TAMANHO_CODIGO_SEGURANCA);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < TAMANHO_CODIGO_SEGURANCA; i++) {
            int digito = random.nextInt(10);
            codigo.append(digito);
        }

        return codigo.toString();
    }
}
