package projetointegrador.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.DepthTest;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

// Classe responsável por controlar a interface de cadastro de uma ação
public class CadastroAcao {

    // Objeto Quadro
    private Quadro quadro = new Quadro();

    private int index;

    // Referências aos elementos da interface gráfica (FXML)

    @FXML
    private ComboBox comBoxA; // ComboBox para atividades

    @FXML
    private ComboBox  ComboDep;

    @FXML
    private ComboBox ComboResp;

    @FXML
    private DatePicker DataInicio; // Campo de texto para data de início

    @FXML
    private DatePicker DataFim; // Campo de texto para data final

    @FXML
    private TextField tNome; // Campo de texto para nome

    @FXML
    private Button bSave; // Botão de salvar

    @FXML
    private Button BotaoFecharAba;

    // Getter e setter para o objeto Quadro
    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }

    // Método para atualizar o ComboBox de projetos
    @FXML
    protected void AtualizaComboBoxP() {
        ObservableList<String> observableListDep;
        observableListDep = FXCollections.observableArrayList(quadro.getDepartamentos());
        ComboDep.setItems(observableListDep);
        ObservableList<User> observableListUser;
        observableListUser = FXCollections.observableArrayList(quadro.getUsers());
        ComboResp.setItems(observableListUser);
    }

    protected void incializa(){
        AtualizaComboBoxP();
        //AtualizaComboBoxA();
    }


    // Método para habilitar o ComboBox de atividades se houver projetos


    // Método para atualizar o ComboBox de atividades com base no projeto selecionado
    @FXML
    protected void AtualizaComboBoxA() {
        ObservableList<Atividade> observableList;
        observableList = FXCollections.observableArrayList(quadro.retornaProjeto().get(index).retornaAtividade());
        comBoxA.setItems(observableList);
    }


    @FXML
    protected void saveAcao(){

        LocalDate dataInicio = DataInicio.getValue();
        LocalDate dataFinal = DataFim.getValue();
        System.out.println(DataInicio.getValue());
        String nome = tNome.getText();
        String Responsalvel = quadro.getUsers().get(ComboResp.getSelectionModel().getSelectedIndex()).getName();
        String Departmamento = quadro.getDepartamentos().get(ComboDep.getSelectionModel().getSelectedIndex());

        quadro.retornaProjeto().get(index).retornaAtividade().get(comBoxA.getSelectionModel().getSelectedIndex()).
              addObject(new Acao(dataInicio,dataFinal,nome, Responsalvel,Departmamento));

        Stage stage = (Stage) bSave.getScene().getWindow();
        stage.close();

    }
    @FXML
    protected void AttCbdep(){

    }
    @FXML
    protected void AttCbResp(){

    }
    @FXML
    protected void botaoFechar(){
        Stage stage = (Stage) BotaoFecharAba.getScene().getWindow();
        stage.close();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
