package med.voll.api.model.dto.paciente;

import med.voll.api.model.Paciente;

public record DadosListagemPacienteDTO(Long id,
                                       String nome,

                                       String email,

                                       String cpf) {
    public DadosListagemPacienteDTO(Paciente paciente) {
        this(paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf());
    }
}
