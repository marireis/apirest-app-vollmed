package med.voll.api.model.dto.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.dto.DadosEnderecoDTO;

public record DadosCadastroPacienteDTO(@NotBlank
                                       String nome,
                                       @NotBlank
                                       @Email
                                       String email,

                                       @NotBlank
                                       String telefone,
                                       @NotBlank
                                       @Pattern(regexp = "\\d{11}")
                                       String cpf,

                                       @NotNull @Valid
                                       DadosEnderecoDTO endereco) {
}
