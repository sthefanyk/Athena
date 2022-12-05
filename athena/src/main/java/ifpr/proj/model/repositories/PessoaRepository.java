package ifpr.proj.model.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import ifpr.proj.model.daos.PessoaDAO;
import ifpr.proj.model.entities.CorRaca;
import ifpr.proj.model.entities.Endereco;
import ifpr.proj.model.entities.Estado;
import ifpr.proj.model.entities.Cidade;
import ifpr.proj.model.entities.Contato;
import ifpr.proj.model.entities.Pessoa;
import ifpr.proj.model.entities.Rg;
import ifpr.proj.model.entities.Sexo;
import ifpr.proj.model.results.Result;

public class PessoaRepository {
    private List<Pessoa> pessoas;
    private List<Estado> estados;
    private List<Cidade> cidades;
    private PessoaDAO dao;

    public PessoaRepository(PessoaDAO dao) {
        this.dao = dao;
    }

    public Result insertPessoa(Pessoa pessoa){

        Optional<Pessoa> busca = pessoas.stream().filter((pe)->pe.getCpf().equals(pessoa.getCpf())).findFirst();
        
        if(busca.isPresent()){
            return Result.fail("CPF já cadastrado!");
        }

        busca = pessoas.stream().filter((pe)->pe.getRg().equals(pessoa.getRg())).findFirst();

        if(busca.isPresent()){
            return Result.fail("RG já cadastrado!");
        }
        
        return dao.insert(pessoa);
            
    }

    public List<Pessoa> getPessoas(){
        pessoas = dao.listAll();
        return Collections.unmodifiableList(pessoas);
    }

    public List<Estado> getEstados(){
        estados = dao.listAllEstados();
        return Collections.unmodifiableList(estados);
    }

    public List<Cidade> getCidades(){
        cidades = dao.listAllCidades();
        return Collections.unmodifiableList(cidades);
    }


    
}
