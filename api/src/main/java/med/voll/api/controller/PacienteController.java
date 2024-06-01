package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.Paciente;
import med.voll.api.model.dto.medico.DadosCadastroMedicoDTO;
import med.voll.api.model.dto.medico.DadosDetalhamentoMedicoDTO;
import med.voll.api.model.dto.paciente.DadosAtualizarPacienteDTO;
import med.voll.api.model.dto.paciente.DadosCadastroPacienteDTO;
import med.voll.api.model.dto.paciente.DadosDetalhamentoPacienteDTO;
import med.voll.api.model.dto.paciente.DadosListagemPacienteDTO;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPacienteDTO dados, UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(dados);
        repository.save(new Paciente(dados));
        var uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPacienteDTO(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPacienteDTO>> listarPacientes(Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemPacienteDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarPacienteDTO dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPacienteDTO(paciente));
    }

    //desativar do banco o cadastro, não deletar
    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharPaciente(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPacienteDTO(paciente));
    }
}
