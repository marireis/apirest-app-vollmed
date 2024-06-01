package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.Medico;
import med.voll.api.model.dto.medico.DadosAtualizarMedicoDTO;
import med.voll.api.model.dto.medico.DadosCadastroMedicoDTO;
import med.voll.api.model.dto.medico.DadosListagemMedicoDTO;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedicoDTO> listarMedicos(Pageable paginacao){
       return repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemMedicoDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedicoDTO dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    }

    //desativar do banco o cadastro, não deletar
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

}
