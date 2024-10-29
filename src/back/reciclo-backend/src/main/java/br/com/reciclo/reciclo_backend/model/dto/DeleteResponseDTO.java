package br.com.reciclo.reciclo_backend.model.dto;

import org.springframework.http.HttpStatus;

public record DeleteResponseDTO(HttpStatus status, String message) {
}
