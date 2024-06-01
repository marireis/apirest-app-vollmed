package med.voll.api.model.dto;

public record DadosAtualizarMedicoDTO(Long id,
                                      String nome,
                                      String telefone,
                                      DadosEnderecoDTO endereo)
{}
