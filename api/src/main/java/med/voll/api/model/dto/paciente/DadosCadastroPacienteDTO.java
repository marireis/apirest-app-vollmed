package med.voll.api.model.dto.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.dto.endereco.DadosEnderecoDTO;

public record DadosCadastroPacienteDTO(@NotBlank(message = "Nome é obrigatório")
                                       String nome,
                                       @NotBlank(message = "Email é obrigatório")
                                       @Email
                                       String email,

                                       @NotBlank(message = "Telefone é obrigatório")
                                       String telefone,
                                       @NotBlank(message = "CPF é obrigatório")
                                       @Pattern(regexp = "\\d{11}",message = "Formato do CPF é inválido")
                                       String cpf,

                                       @NotNull (message = "Endereço é obrigatório")
                                       @Valid
                                       DadosEnderecoDTO endereco) {
}
