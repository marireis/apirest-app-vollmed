package med.voll.api.model.dto;

import med.voll.api.model.Especialidade;

public record DadosCadastroMedicoDTO(String nome,
                                     String email,
                                     String crm,
                                     Especialidade especialidade,
                                     DadosEnderecoDTO endereco) {
}