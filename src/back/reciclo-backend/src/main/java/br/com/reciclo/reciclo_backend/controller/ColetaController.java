package br.com.reciclo.reciclo_backend.controller;


import br.com.reciclo.reciclo_backend.model.Coleta;
import br.com.reciclo.reciclo_backend.model.dto.ColetaDTO;
import br.com.reciclo.reciclo_backend.model.dto.ColetaRequestDTO;
import br.com.reciclo.reciclo_backend.service.ColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coletas")
public class ColetaController {

    @Autowired
    private ColetaService coletaService;

    @PostMapping("/cadastrar/{produtorId}/{residuoId}")
    public ResponseEntity<?> cadastrarColeta(@PathVariable Long produtorId,
                                             @PathVariable Long residuoId,
                                             @RequestBody ColetaRequestDTO coletaRequestDTO) {
        ColetaDTO novColeta = coletaService.cadastrarColeta(produtorId, residuoId, coletaRequestDTO);
        return ResponseEntity.ok(novColeta);
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
    public ResponseEntity<?> listarColetas() {
        List<ColetaDTO> coletas = coletaService.listarColetas();
        return ResponseEntity.ok(coletas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarColeta(@PathVariable Long coletaId) {
        Coleta coleta = coletaService.buscarColeta(coletaId);
        ColetaDTO dto = coleta.toDTO();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/delete/{coletaId}")
    public @ResponseBody Boolean deletarColeta(@PathVariable Long coletaId) {
        return coletaService.deletarColeta(coletaId);
    }
}
