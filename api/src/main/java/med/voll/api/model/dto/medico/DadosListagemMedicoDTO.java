package med.voll.api.model.dto.medico;

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
