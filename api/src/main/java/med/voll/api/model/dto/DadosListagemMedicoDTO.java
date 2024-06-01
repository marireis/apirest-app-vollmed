package med.voll.api.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.Especialidade;
import med.voll.api.model.Medico;

public record DadosListagemMedicoDTO(Long id,
                                     String nome,

                                     String email,

                                     String crm,

                                     Especialidade especialidade) {
    public DadosListagemMedicoDTO(Medico medico) {
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade());
    }
}
