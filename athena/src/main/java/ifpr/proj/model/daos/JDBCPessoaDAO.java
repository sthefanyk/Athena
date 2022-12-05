package ifpr.proj.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ifpr.proj.model.FabricaConexoes;
import ifpr.proj.model.entities.Cidade;
import ifpr.proj.model.entities.Contato;
import ifpr.proj.model.entities.CorRaca;
import ifpr.proj.model.entities.Email;
import ifpr.proj.model.entities.Endereco;
import ifpr.proj.model.entities.Estado;
import ifpr.proj.model.entities.Pais;
import ifpr.proj.model.entities.Pessoa;
import ifpr.proj.model.entities.Rg;
import ifpr.proj.model.entities.Sexo;
import ifpr.proj.model.entities.Telefone;
import ifpr.proj.model.results.Result;

public class JDBCPessoaDAO implements PessoaDAO{

    private static final String INSERT = "INSERT INTO athena_pessoa(cpf,primeiroNome,ultimoNome,sexo,corRaca,possuiNecessidadesEspecificas,contatoID,enderecoID,rgID) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERT_TELEFONE = "INSERT INTO athena_telefone(telefone) VALUES (?)";
    private static final String INSERT_EMAIL = "INSERT INTO athena_email(email) VALUES (?)";
    //private static final String UPDATE = "UPDATE produtos set nome=?, descricao=?, valor=?, quantidadeEstoque=? WHERE id=?";
    private static final String SELECT_ALL = "CALL getPessoa()";
    private static final String SELECT_ALL_ESTADOS = "CALL getEstado()";
    private static final String SELECT_ALL_CIDADES = "CALL getCidade()";
    //private static final String SELECT_ID = "SELECT * FROM produtos WHERE id=?";

    private FabricaConexoes fabricaConexoes;

    public JDBCPessoaDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result insert(Pessoa pessoa) {
        try{
            //criando uma conexão
            Connection con = fabricaConexoes.getConnection(); 
            
            //preparando o comando sql
            PreparedStatement pstm = con.prepareStatement(INSERT);
            
            //ajustando os parâmetros do comando
            pstm.setString(1, pessoa.getCpf());
            pstm.setString(2, pessoa.getPrimeiroNome());
            pstm.setString(3, pessoa.getUltimoNome());
            pstm.setString(4, getSexo(pessoa));
            pstm.setString(5, getCorRaca(pessoa));
            pstm.setInt(6, getNesc(pessoa));
            pstm.setInt(7, pessoa.getContatoID());
            pstm.setInt(8, pessoa.getEnderecoID());
            pstm.setInt(9, pessoa.getRgID());

            pstm.execute();

            pstm.close();
            con.close();

            return Result.success("Pessoa criada com sucesso!");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @Override
    public Result update(int id, Pessoa pessoa) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Pessoa> listAll() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        try{
            Connection con = fabricaConexoes.getConnection(); 
            
            PreparedStatement pstm = con.prepareStatement(SELECT_ALL);

            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Pessoa pessoa = buildFrom(rs);
                pessoas.add(pessoa);
            }

            rs.close();
            pstm.close();
            con.close();

            return pessoas;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    

    @Override
    public Pessoa getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    private String getSexo(Pessoa pessoa){
        if(pessoa.getSexo() == Sexo.FEMININO) return Sexo.FEMININO.name();
        return Sexo.MASCULINO.name();
    }

    private String getCorRaca(Pessoa pessoa){
        if(pessoa.getCorRaca() == CorRaca.BRANCO) return CorRaca.BRANCO.name();
        if(pessoa.getCorRaca() == CorRaca.PARDO) return CorRaca.PARDO.name();
        if(pessoa.getCorRaca() == CorRaca.PRETO) return CorRaca.PRETO.name();
        return CorRaca.INDIGENA.name();
    }

    private int getNesc(Pessoa pessoa){
        if(pessoa.isPossuiNecessidadesEspecificas()) return 1;
        return 0;
    }

    private Pessoa buildFrom(ResultSet result) throws SQLException{
        int pessoaID = result.getInt("pessoaID");
        String cpf = result.getString("CPF");
        String primeiroNome = result.getString("primeiroNome");
        String ultimoNome = result.getString("ultimoNome");
        boolean possuiNecessidadesEspecificas = result.getBoolean("possuiNecessidadesEspecificas");
        String sexo = result.getString("sexo");
        String corRaca = result.getString("corRaca");

        int rgID = result.getInt("rgID");
        String rgg = result.getString("rg");
        String nome = result.getString("nome");
        String dataExpedicao = result.getString("dataExpedicao");
        String orgaoExpedidor = result.getString("orgaoExpedidor");
        String nomeMae = result.getString("nomeMae");
        String nomePai = result.getString("nomePai");
        String naturalidadee = result.getString("naturalidade");
        String uff = result.getString("uf");

        int contatoID = result.getInt("contatoID");

        int telefoneID = result.getInt("telefoneID");
        String telefonee = result.getString("telefone");

        int emailID = result.getInt("emailID");
        String emaill = result.getString("email");

        int enderecoID = result.getInt("enderecoID");
        String cep = result.getString("cep");
        String logradouro = result.getString("logradouro");
        String bairro = result.getString("bairro");
        String numero = result.getString("numero");
        String complemento = result.getString("complemento");

        int cidadeID = result.getInt("cidadeID");
        String cidadee = result.getString("cidade");

        int estadoID = result.getInt("estadoID");
        String estadoo = result.getString("estado");

        int paisID = result.getInt("paisID");
        String paiss = result.getString("pais");

        Pais pais = new Pais(paisID, paiss);
        Estado estado = new Estado(estadoID, estadoo, pais);
        Cidade cidade = new Cidade(cidadeID, cidadee, estado);
        Endereco endereco = new Endereco(enderecoID, cep, logradouro, bairro, numero, complemento, cidade);

        Telefone telefone = new Telefone(telefoneID, telefonee);
        Email email = new Email(emailID, emaill);
        Contato contato = new Contato(contatoID, email, telefone);

        Cidade naturalidade = new Cidade(naturalidadee);
        Estado uf = new Estado(uff);
        Rg rg = new Rg(rgID, rgg, nome, null, orgaoExpedidor, nomeMae, nomePai, naturalidade, uf);

        // "15 de dez de 2022"
        String data = dataExpedicao;
        LocalDate dataFormatada = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        rg.setDataExpedicao(dataFormatada);

        Pessoa pessoa = new Pessoa(pessoaID, cpf, primeiroNome, ultimoNome, null, null, possuiNecessidadesEspecificas, rg, contato, endereco);

        if (sexo.equals(Sexo.FEMININO.getSexo())) pessoa.setSexo(Sexo.FEMININO);
        else pessoa.setSexo(Sexo.MASCULINO);

        if (corRaca.equals(CorRaca.BRANCO.getCorRaca())) pessoa.setCorRaca(CorRaca.BRANCO);
        if (corRaca.equals(CorRaca.PARDO.getCorRaca())) pessoa.setCorRaca(CorRaca.PARDO);
        if (corRaca.equals(CorRaca.PRETO.getCorRaca())) pessoa.setCorRaca(CorRaca.BRANCO);
        else pessoa.setCorRaca(CorRaca.INDIGENA);

        return pessoa;
    }

    @Override
    public List<Estado> listAllEstados() {
        ArrayList<Estado> estados = new ArrayList<>();
        try{
            Connection con = fabricaConexoes.getConnection(); 
            
            PreparedStatement pstm = con.prepareStatement(SELECT_ALL_ESTADOS);

            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Estado estado = buildFromEstados(rs);
                estados.add(estado);
            }

            rs.close();
            pstm.close();
            con.close();

            return estados;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Estado buildFromEstados(ResultSet result) throws SQLException{
        int estadoID = result.getInt("estadoID");
        String estadoo = result.getString("estado");
        int paisID = result.getInt("paisID");
        String paiss = result.getString("pais");

        Pais pais = new Pais(paisID, paiss);
        Estado estado = new Estado(estadoID, estadoo, pais);

        return estado;

    }

    @Override
    public List<Cidade> listAllCidades() {
        ArrayList<Cidade> cidades = new ArrayList<>();
        try{
            Connection con = fabricaConexoes.getConnection(); 
            
            PreparedStatement pstm = con.prepareStatement(SELECT_ALL_CIDADES);

            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Cidade cidade = buildFromCidades(rs);
                cidades.add(cidade);
            }

            rs.close();
            pstm.close();
            con.close();

            return cidades;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Cidade buildFromCidades(ResultSet result) throws SQLException{
        int cidadeID = result.getInt("cidadeID");
        String cidadee = result.getString("cidade");
        int estadoID = result.getInt("estadoID");
        String estadoo = result.getString("estado");
        int paisID = result.getInt("paisID");
        String paiss = result.getString("pais");

        Pais pais = new Pais(paisID, paiss);
        Estado estado = new Estado(estadoID, estadoo, pais);
        Cidade cidade = new Cidade(cidadeID, cidadee, estado);

        return cidade;
    }
    
}
