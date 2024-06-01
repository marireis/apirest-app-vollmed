package med.voll.api.model.dto.paciente;

import med.voll.api.model.Endereco;
import med.voll.api.model.Paciente;

public record DadosDetalhamentoPacienteDTO(Long id,
                                           String nome,
                                           String telefone,
                                           String email,
                                           String cpf,
                                           Endereco endereco) {

    public DadosDetalhamentoPacienteDTO(Paciente paciente) {
        this(paciente.getId(),
                paciente.getNome(),
                paciente.getTelefone(),
                paciente.getEmail(),
                paciente.getCpf(),
                paciente.getEndereco());
    }
}
