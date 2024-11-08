package br.com.reciclo.reciclo_backend.controller;


import br.com.reciclo.reciclo_backend.exception.ResourceNotFoundException;
import br.com.reciclo.reciclo_backend.model.Coleta;
import br.com.reciclo.reciclo_backend.model.Residuos;
import br.com.reciclo.reciclo_backend.model.Usuarios;
import br.com.reciclo.reciclo_backend.model.dto.ColetaDTO;
import br.com.reciclo.reciclo_backend.model.dto.ColetaRequestDTO;
import br.com.reciclo.reciclo_backend.model.dto.DeleteResponseDTO;
import br.com.reciclo.reciclo_backend.model.enums.StatusColeta;
import br.com.reciclo.reciclo_backend.service.ColetaService;
import br.com.reciclo.reciclo_backend.service.ResiduosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/coletas")
public class ColetaController {

    @Autowired
    private ColetaService coletaService;

    @Autowired
    private ResiduosService residuoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ColetaDTO> cadastrarColeta(Authentication authentication, @RequestBody ColetaRequestDTO data) {
        Usuarios produtor = (Usuarios) authentication.getPrincipal();
        ColetaDTO coleta = this.coletaService.cadastrarColeta(produtor, data);
        return ResponseEntity.status(HttpStatus.CREATED).body(coleta);
    }

    @PutMapping("/requisitar/{coletorId}/{coletaId}")
    public ResponseEntity<?> requisitarColeta(@PathVariable Long coletorId, @PathVariable Long coletaId) {
        ColetaDTO coleta = coletaService.requisitarColeta(coletorId, coletaId);
        if (coleta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coleta ou coletor não encontrada");
        }
        return ResponseEntity.ok(coleta);
    }

    @PutMapping("/aceitar/{reposta}/{coletaId}")
    public ResponseEntity<?> aceitarDemanda(@PathVariable Boolean resposta, @PathVariable Long coletaId) {
        ColetaDTO coleta = coletaService.aceitarDemanda(resposta, coletaId);
        if (coleta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coleta não encontrada");
        }
        return ResponseEntity.ok(coleta);
    }

    @PutMapping("/entrega/{resposta}/{coletaId}")
    public ResponseEntity<?> entregaColeta(@PathVariable Boolean resposta, @PathVariable Long coletaId) {
        if (!(resposta instanceof Boolean)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reposta deve ser um Booleano");
        }
        ColetaDTO coleta = coletaService.entregaColeta(resposta, coletaId);
        if (coleta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coleta não encontrada");
        }
        return ResponseEntity.ok(coleta);
    }

    @GetMapping
    public ResponseEntity<List<ColetaDTO>> listarColetas(@RequestParam(required = false) String status) {
        List<ColetaDTO> coletas;

        try {
            if (status != null) {
                StatusColeta statusColeta = StatusColeta.fromValue(status);
                coletas = coletaService.listarColetasPorStatus(statusColeta);
            } else {
                coletas = coletaService.listarColetas();
            }

            return ResponseEntity.ok(coletas);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarColeta(@PathVariable Long coletaId) {
        Coleta coleta = coletaService.buscarColeta(coletaId);
        ColetaDTO dto = coleta.toDTO();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/delete/{coletaId}")
    public @ResponseBody ResponseEntity<DeleteResponseDTO> deletarColeta(@PathVariable Long coletaId) {
        try {
            coletaService.deletarColeta(coletaId);
            return new ResponseEntity<>(new DeleteResponseDTO(HttpStatus.OK, "Coleta deletada com sucesso."), HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(new DeleteResponseDTO(HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(new DeleteResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
