package med.voll.api.model.dto.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsultaDTO(
    Long idMedico,
    @NotNull
    Long idPaciente,
    @NotNull
    @Future
    LocalDateTime data){
}
