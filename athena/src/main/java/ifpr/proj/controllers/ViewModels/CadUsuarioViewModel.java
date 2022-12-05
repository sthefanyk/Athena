package ifpr.proj.controllers.ViewModels;

import ifpr.proj.model.repositories.PessoaRepository;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CadUsuarioViewModel {

    //private ObservableList<UsuarioRow> obsClientes = FXCollections.observableArrayList();

    private PessoaRepository repository;

    public CadUsuarioViewModel(PessoaRepository repository) {

        this.repository = repository;

        updateList();

    }

    private void updateList() {
        obsClientes.clear();
        for (Cliente c : repository.getClientes()) {
            obsClientes.add(new ClienteRow(c));
        }
    }

    public void cadastrar() {
        /*
        String nome = spNome.getValue();
        String cpf = spCpf.getValue();
        String telefone = spTelefone.getValue();
        String email = spEmail.getValue();

        if (atualizar) {
            repository.atualizarCliente(cpf, email, telefone);
        } else {
            repository.adicionarCliente(nome, cpf, email, telefone);
        }

        updateList();
        limpar();
        */
    }

    public void limpar() {
    }
}
