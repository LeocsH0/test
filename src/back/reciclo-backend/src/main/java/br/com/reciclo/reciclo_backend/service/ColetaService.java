package br.com.reciclo.reciclo_backend.service;

import br.com.reciclo.reciclo_backend.exception.ResourceNotFoundException;
import br.com.reciclo.reciclo_backend.factory.EnderecoFactory;
import br.com.reciclo.reciclo_backend.factory.ResiduoFactory;
import br.com.reciclo.reciclo_backend.model.Coleta;
import br.com.reciclo.reciclo_backend.model.Endereco;
import br.com.reciclo.reciclo_backend.model.Residuos;
import br.com.reciclo.reciclo_backend.model.Usuarios;
import br.com.reciclo.reciclo_backend.model.dto.ColetaDTO;
import br.com.reciclo.reciclo_backend.model.dto.ColetaRequestDTO;
import br.com.reciclo.reciclo_backend.model.enums.StatusColeta;
import br.com.reciclo.reciclo_backend.respositories.ColetaRepository;
import br.com.reciclo.reciclo_backend.respositories.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ColetaService {
    private final ColetaRepository coletaRepository;
    private final UsuariosRepository usuariosRepository;

    public ColetaService(ColetaRepository coletaRepository, UsuariosRepository usuariosRepository) {
        this.coletaRepository = coletaRepository;
        this.usuariosRepository = usuariosRepository;
    }

    public ColetaDTO cadastrarColeta(Usuarios produtor, ColetaRequestDTO dto) {
        Residuos residuo = ResiduoFactory.criar(dto);
        Endereco endereco = EnderecoFactory.criar(dto);
        Coleta novColeta = new Coleta(produtor, residuo, endereco);

        this.coletaRepository.save(novColeta);
        return novColeta.toDTO();
    }

    public ColetaDTO requisitarColeta(Long coletorId, Long coletaId) {
        Coleta coleta = buscarColeta(coletaId);
        Optional<Usuarios> usuarioOptional = this.usuariosRepository.findById(coletorId);
        if (coleta == null || usuarioOptional.isEmpty()) {
            return null;
        }
        Usuarios coletor = usuarioOptional.get();
        coleta.requisitarColeta(coletor);
        this.coletaRepository.save(coleta);
        return coleta.toDTO();
    }

    public ColetaDTO aceitarDemanda(Boolean resposta, Long coletaId) {
        Coleta coleta = buscarColeta(coletaId);
        coleta.aceitarDemanda(resposta);
        this.coletaRepository.save(coleta);
        return coleta.toDTO();
    }

    public ColetaDTO entregaColeta(Boolean resposta, Long coletaId) {
        Coleta coleta = buscarColeta(coletaId);
        coleta.entregaColeta(resposta);
        this.coletaRepository.save(coleta);
        return coleta.toDTO();
    }

    public List<ColetaDTO> listarColetas() {
        List<Coleta> coletas = this.coletaRepository.findAll();
        List<ColetaDTO> coletasDTO = new ArrayList<>();
        for (Coleta c : coletas) {
            ColetaDTO dto = c.toDTO();
            coletasDTO.add(dto);
        }
        return coletasDTO;
    }

    public List<ColetaDTO> listarColetasPorStatus(StatusColeta status) {
        List<Coleta> coletas = this.coletaRepository.findByStatus(status);
        List<ColetaDTO> coletasDTO = new ArrayList<>();
        for (Coleta c : coletas) {
            ColetaDTO dto = c.toDTO();
            coletasDTO.add(dto);
        }
        return coletasDTO;
    }

    public void deletarColeta(Long coletaId) {
        if (!coletaRepository.existsById(coletaId)) {
            throw new ResourceNotFoundException("Coleta não encontrada.");
        }

        try {
            coletaRepository.deleteById(coletaId);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a coleta.");
        }
    }

    public Coleta buscarColeta(Long coletaId) {
        Optional<Coleta> coletaOptional = this.coletaRepository.findById(coletaId);
        if (coletaOptional.isEmpty()) {
            return null;
        }
        Coleta coleta = coletaOptional.get();
        return coleta;
    }
}