package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.Paciente;
import med.voll.api.model.dto.paciente.DadosAtualizarPacienteDTO;
import med.voll.api.model.dto.paciente.DadosCadastroPacienteDTO;
import med.voll.api.model.dto.paciente.DadosListagemPacienteDTO;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPacienteDTO dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacienteDTO> listarPacientes(Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemPacienteDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarPacienteDTO dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);

    }

    //desativar do banco o cadastro, não deletar
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }
}
