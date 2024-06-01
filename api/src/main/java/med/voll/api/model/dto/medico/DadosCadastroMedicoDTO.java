package med.voll.api.model.dto.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.Especialidade;
import med.voll.api.model.dto.endereco.DadosEnderecoDTO;

public record DadosCadastroMedicoDTO(@NotBlank(message = "Nome é obrigatório")
                                     String nome,
                                     @NotBlank(message = "Email é obrigatório")
                                     @Email
                                     String email,

                                     @NotBlank(message = "Telefone é obrigatório")
                                     String telefone,
                                     @NotBlank(message = "CRM é obrigatório")
                                     @Pattern(regexp = "\\d{4,6}", message = "Formato do CRM é inválido")
                                     String crm,
                                     @NotNull(message = "Especialidade é obrigatória")
                                     Especialidade especialidade,

                                     @NotNull(message = "Dados do endereço são obrigatórios")
                                     @Valid
                                     DadosEnderecoDTO endereco) {
}