package med.voll.api.model.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEnderecoDTO(@NotBlank(message = "Logradouro é obrigatório")
                               String logradouro,
                               @NotBlank(message = "Bairro é obrigatório")
                               String bairro,
                               @NotBlank(message = "CEP é obrigatório")
                               @Pattern(regexp = "\\d{8}", message = "Formato do CEP é inválido")
                               String cep,
                               @NotBlank(message = "Cidade é obrigatório")
                               String cidade,
                               @NotBlank(message = "Uf é obrigatório")
                               String uf,
                               String complemento,
                               String numero) {
}
