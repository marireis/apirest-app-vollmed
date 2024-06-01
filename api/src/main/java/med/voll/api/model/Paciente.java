package med.voll.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.dto.paciente.DadosAtualizarPacienteDTO;
import med.voll.api.model.dto.paciente.DadosCadastroPacienteDTO;

@Entity(name = "Paciente")
@Table(name="pacientes")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    private String telefone;

    private String cpf;
    @Embedded
    private Endereco endereco;
    private boolean ativo;


    public Paciente(DadosCadastroPacienteDTO dados) {

        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void atualizarInformacoes(DadosAtualizarPacienteDTO dados) {
        if(dados.nome() !=null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoesEndereco(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }


}
