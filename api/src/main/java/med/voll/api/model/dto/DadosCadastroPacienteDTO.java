package med.voll.api.model.dto;

public record DadosCadastroPacienteDTO(String nome,
                                       String email,
                                       String telefone,
                                       String cpf,
                                       DadosEnderecoDTO endereco) {
}
