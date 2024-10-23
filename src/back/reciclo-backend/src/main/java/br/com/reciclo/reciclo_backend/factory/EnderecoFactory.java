package br.com.reciclo.reciclo_backend.factory;

import br.com.reciclo.reciclo_backend.model.Endereco;
import br.com.reciclo.reciclo_backend.model.dto.ColetaRequestDTO;

public class EnderecoFactory {
    public static Endereco criar(ColetaRequestDTO dto) {
        return new Endereco(
                dto.logradouro(),
                dto.numero(),
                dto.complemento(),
                dto.bairro(),
                dto.cidade(),
                dto.estado(),
                dto.cep()
        );
    }
}
