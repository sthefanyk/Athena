package ifpr.proj.model.daos;

import java.util.List;

import ifpr.proj.model.entities.Usuario;
import ifpr.proj.model.results.Result;

public interface UsuarioDAO {
    Result insert(Usuario usuario);
    Result update(int id,Usuario usuario);
    List<Usuario> listAll();
    Usuario getById(int id);
    Result delete(int id);
}
