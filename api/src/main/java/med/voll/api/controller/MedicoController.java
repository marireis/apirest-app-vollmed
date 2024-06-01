package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.Medico;
import med.voll.api.model.dto.medico.DadosAtualizarMedicoDTO;
import med.voll.api.model.dto.medico.DadosCadastroMedicoDTO;
import med.voll.api.model.dto.medico.DadosDetalhamentoMedico;
import med.voll.api.model.dto.medico.DadosListagemMedicoDTO;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();//pega a url da requisição
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));//retornar 201, cabeçalho e body
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicoDTO>> listarMedicos(Pageable paginacao){
       var page = repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemMedicoDTO::new);
       return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarMedicoDTO dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    //desativar do banco o cadastro, não deletar
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();//codigo 204 para dizer que foi excluido mas não tem retorno
    }

}
