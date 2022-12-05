package ifpr.proj.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ifpr.proj.model.FabricaConexoes;
import ifpr.proj.model.entities.Nivel;
import ifpr.proj.model.entities.Usuario;
import ifpr.proj.model.results.Result;

public class JDBCUsuarioDAO implements UsuarioDAO{

    private static final String INSERT = "INSERT INTO athena_usuario(pessoaID,login,senha,tipoUsuarioID) VALUES (?,?,?,?)";
    //private static final String UPDATE = "UPDATE produtos set nome=?, descricao=?, valor=?, quantidadeEstoque=? WHERE id=?";
    private static final String SELECT_ALL = "CALL getPessoa()";
    //private static final String SELECT_ID = "SELECT * FROM produtos WHERE id=?";

    private FabricaConexoes fabricaConexoes;

    public JDBCUsuarioDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result insert(Usuario usuario) {
        try{
            //criando uma conexão
            Connection con = fabricaConexoes.getConnection();

            //preparando o comando sql
            PreparedStatement pstm = con.prepareStatement(INSERT);
            
            //ajustando os parâmetros do comando
            pstm.setInt(1, usuario.getPessoaID());
            pstm.setString(2, usuario.getLogin());
            pstm.setString(3, usuario.getSenha());
            pstm.setString(4, getNivel(usuario));

            pstm.execute();

            pstm.close();
            con.close();
            return Result.success("Usuario criado com sucesso!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @Override
    public Result update(int id, Usuario usuario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Usuario> listAll() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try{
            //criando uma conexão
            Connection con = fabricaConexoes.getConnection(); 
            
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM usuarios");

            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Usuario usuario = buildFrom(rs);
                usuarios.add(usuario);
            }

            return usuarios;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Usuario getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    
    private String getNivel(Usuario usuario){
        if(usuario.getNivel() == Nivel.ADMIN) return Nivel.ADMIN.getTipo();
        if(usuario.getNivel() == Nivel.ALUNO) return Nivel.ALUNO.getTipo();
        if(usuario.getNivel() == Nivel.PROFESSOR) return Nivel.PROFESSOR.getTipo();
        return Nivel.COORDENACAO.getTipo();
    }

    private Usuario buildFrom(ResultSet rs) throws SQLException{
        
        Usuario usuario = new Usuario(SELECT_ALL, INSERT, null);
        
        return usuario;
    }

}
