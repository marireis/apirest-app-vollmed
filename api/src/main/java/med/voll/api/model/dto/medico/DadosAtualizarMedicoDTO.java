package med.voll.api.model.dto.medico;

import med.voll.api.model.dto.endereco.DadosEnderecoDTO;

public record DadosAtualizarMedicoDTO(Long id,
                                      String nome,
                                      String telefone,
                                      DadosEnderecoDTO endereco)
{}
