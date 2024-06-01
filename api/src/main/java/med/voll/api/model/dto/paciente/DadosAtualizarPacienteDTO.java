package med.voll.api.model.dto.paciente;

import med.voll.api.model.dto.DadosEnderecoDTO;

public record DadosAtualizarPacienteDTO(Long id,
                                        String nome,
                                        String telefone,
                                        DadosEnderecoDTO endereco) {
}
