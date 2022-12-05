package ifpr.proj.model.daos;

import java.util.List;

import ifpr.proj.model.entities.Pessoa;
import ifpr.proj.model.results.Result;

public interface PessoaDAO {
    Result insert(Pessoa pessoa);
    Result update(int id,Pessoa pessoa);
    List<Pessoa> listAll();
    Pessoa getById(int id);
    Result delete(int id);
}
