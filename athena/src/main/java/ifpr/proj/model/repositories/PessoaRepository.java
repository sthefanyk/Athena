package ifpr.proj.model.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import ifpr.proj.model.daos.PessoaDAO;
import ifpr.proj.model.entities.CorRaca;
import ifpr.proj.model.entities.Endereco;
import ifpr.proj.model.entities.Contato;
import ifpr.proj.model.entities.Pessoa;
import ifpr.proj.model.entities.Rg;
import ifpr.proj.model.entities.Sexo;
import ifpr.proj.model.results.Result;

public class PessoaRepository {
    private List<Pessoa> pessoas;
    private PessoaDAO dao;

    public PessoaRepository(PessoaDAO dao) {
        this.dao = dao;
    }

    public Result insertPessoa(String cPF, String primeiroNome, String ultimoNome, Sexo sexo, CorRaca corRaca,
    boolean possuiNecessidadesEspecificas, Rg rG, Contato contato, Endereco endereco){

        Optional<Pessoa> busca = pessoas.stream().filter((pe)->pe.getCpf().equals(cPF)).findFirst();
        
        if(busca.isPresent()){
            return Result.fail("CPF já cadastrado!");
        }

        busca = pessoas.stream().filter((pe)->pe.getRg().equals(rG)).findFirst();

        if(busca.isPresent()){
            return Result.fail("RG já cadastrado!");
        }


        Pessoa pessoa = new Pessoa(cPF, primeiroNome, ultimoNome, sexo, corRaca, possuiNecessidadesEspecificas, rG, contato, endereco);
        
        return dao.insert(pessoa);
            
    }

    public List<Pessoa> getPessoas(){
        pessoas = dao.listAll();
        return Collections.unmodifiableList(pessoas);
    }


    
}
