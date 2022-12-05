package ifpr.proj.controllers.ViewModels;

import java.time.LocalDate;

import ifpr.proj.model.entities.Cidade;
import ifpr.proj.model.entities.Contato;
import ifpr.proj.model.entities.CorRaca;
import ifpr.proj.model.entities.Email;
import ifpr.proj.model.entities.Endereco;
import ifpr.proj.model.entities.Estado;
import ifpr.proj.model.entities.Nivel;
import ifpr.proj.model.entities.Pessoa;
import ifpr.proj.model.entities.Rg;
import ifpr.proj.model.entities.Sexo;
import ifpr.proj.model.entities.Telefone;
import ifpr.proj.model.repositories.PessoaRepository;
import ifpr.proj.model.results.Result;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CadUsuarioViewModel {

    private StringProperty spCpf = new SimpleStringProperty();
    private StringProperty spPrimeiroNome = new SimpleStringProperty();
    private StringProperty spUltimoNome = new SimpleStringProperty();
    private ObjectProperty<Sexo> opSexo = new SimpleObjectProperty<>();
    private ObjectProperty<CorRaca> opCorRaca = new SimpleObjectProperty<>();
    private BooleanProperty bpPossuiNecessidadesEspecificas = new SimpleBooleanProperty(true);

    private StringProperty spRg = new SimpleStringProperty();
    private StringProperty spNome = new SimpleStringProperty();
    private ObjectProperty<LocalDate> opDataExpedicao = new SimpleObjectProperty<>();
    private StringProperty spOrgaoExpedidor = new SimpleStringProperty();
    private StringProperty spNomeMae = new SimpleStringProperty();
    private StringProperty spNomePai = new SimpleStringProperty();
    private ObjectProperty<Cidade> opNaturalidade = new SimpleObjectProperty<>();
    private ObjectProperty<Estado> opRgUf = new SimpleObjectProperty<>();
    private StringProperty spEmail = new SimpleStringProperty();
    private StringProperty spTelefone = new SimpleStringProperty();
    private StringProperty spCep = new SimpleStringProperty();
    private StringProperty spLogradouro = new SimpleStringProperty();
    private StringProperty spBairro = new SimpleStringProperty();
    private StringProperty spNumero = new SimpleStringProperty();
    private StringProperty spComplemeto = new SimpleStringProperty();
    private ObjectProperty<Cidade> opCidade = new SimpleObjectProperty<>();


    private ObservableList<Estado> estados = FXCollections.observableArrayList();
    private ObservableList<Cidade> cidades = FXCollections.observableArrayList();
    private ObservableList<Sexo> sexos = FXCollections.observableArrayList();
    private ObservableList<CorRaca> corRacas = FXCollections.observableArrayList();
    private ObservableList<Nivel> nivels = FXCollections.observableArrayList();

    //private ObservableList<UsuarioRow> obsClientes = FXCollections.observableArrayList();

    private PessoaRepository repository;

    public CadUsuarioViewModel(PessoaRepository repository) {

        this.repository = repository;

        updateList();
    }
   
    private void updateList() {
        estados.clear();
        estados.addAll(repository.getEstados());
        cidades.clear();
        cidades.addAll(repository.getCidades());
        sexos.addAll(Sexo.FEMININO, Sexo.MASCULINO);
        corRacas.addAll(CorRaca.BRANCO, CorRaca.PARDO, CorRaca.PRETO, CorRaca.INDIGENA);
        nivels.addAll(Nivel.ALUNO, Nivel.PROFESSOR, Nivel.COORDENACAO);
    }

    public ObservableList<Estado> getEstados(){     
        return estados;
    }

    public ObservableList<Cidade> getCidades(){     
        return cidades;
    }

    public ObservableList<Sexo> getSexos(){   
        return sexos;
    }

    public ObservableList<CorRaca> getCorRacas(){   
        return corRacas;
    }

    public ObservableList<Nivel> getNivels(){   
        return nivels;
    }

    
    public Result cadastrar() {
        
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(spCpf.getValue());
        pessoa.setPrimeiroNome(spPrimeiroNome.getValue());
        pessoa.setUltimoNome(null);
        pessoa.setSexo(opSexo.getValue());
        pessoa.setCorRaca(opCorRaca.getValue());
        pessoa.setPossuiNecessidadesEspecificas(bpPossuiNecessidadesEspecificas.getValue());
        
        Rg rg = new Rg();
        rg.setRg(spRg.getValue());
        rg.setNome(spPrimeiroNome.getValue());
        rg.setDataExpedicao(opDataExpedicao.getValue());
        rg.setOrgaoExpedidor(spOrgaoExpedidor.getValue());
        rg.setNomeMae(spNomeMae.getValue());
        rg.setNomePai(spNomePai.getValue());
        rg.setNaturalidade(opNaturalidade.getValue());
        rg.setUf(opRgUf.getValue());

        pessoa.setRg(rg);

        Email email = new Email();
        email.setEmail(spEmail.getValue());
        
        Telefone telefone = new Telefone();
        telefone.setTelefone(spTelefone.getValue());

        Contato contato = new Contato();
        contato.setEmail(email);
        contato.setTelefone(telefone);

        pessoa.setContato(contato);

        Endereco endereco = new Endereco();
        endereco.setCep(spCep.getValue());
        endereco.setLogradouro(spLogradouro.getValue());
        endereco.setBairro(spBairro.getValue());
        endereco.setNumero(spNumero.getValue());
        endereco.setComplemeto(spComplemeto.getValue());
        endereco.setCidade(opCidade.getValue());

        pessoa.setEndereco(endereco);

        
        return this.repository.insertPessoa(pessoa);
    }

    public void limpar() {
    }
}
