package projetointegrador.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.DepthTest;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.Acao;
import projetointegrador.Model.Entities.Atividade;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Quadro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Classe responsável por controlar a interface de cadastro de uma ação
public class CadastroAcao {

    // Objeto Quadro
    private Quadro quadro = new Quadro();

    // Referências aos elementos da interface gráfica (FXML)
    @FXML
    private ComboBox comBoxP; // ComboBox para projetos

    @FXML
    private ComboBox comBoxA; // ComboBox para atividades

    @FXML
    private TextField tDatainicio; // Campo de texto para data de início

    @FXML
    private TextField tDataFinal; // Campo de texto para data final

    @FXML
    private TextField tNome; // Campo de texto para nome

    @FXML
    private TextField tResponsavel; // Campo de texto para responsável

    @FXML
    private TextField tDepartamento; // Campo de texto para responsável


    @FXML
    private Button bSave; // Botão de salvar

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
        ObservableList<Projeto> observableList;
        observableList = FXCollections.observableArrayList(quadro.retornaProjeto());
        comBoxP.setItems(observableList);
    }

    // Método para habilitar o ComboBox de atividades se houver projetos
    @FXML
    protected void habilitaComboBoxA() {
        if (comBoxP.getItems().size() > 0) {
            comBoxA.depthTestProperty().set(DepthTest.ENABLE);
        }
    }

    // Método para atualizar o ComboBox de atividades com base no projeto selecionado
    @FXML
    protected void AtualizaComboBoxA() {
        ObservableList<Atividade> observableList;
        observableList = FXCollections.observableArrayList(quadro.retornaProjeto().get(comBoxP.getSelectionModel().getSelectedIndex()).retornaAtividade());
        comBoxA.setItems(observableList);
    }


    @FXML
    protected void saveAcao(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataInicio = LocalDate.parse(tDatainicio.getText(), dtf);
        LocalDate dataFinal = LocalDate.parse(tDataFinal.getText(), dtf);
        String nome = tNome.getText();
        String Responsalvel = tResponsavel.getText();
        String Departmamento = tDepartamento.getText();

        quadro.retornaProjeto().get(comBoxP.getSelectionModel().getSelectedIndex()).retornaAtividade().get(comBoxA.getSelectionModel().getSelectedIndex()).
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

    }


}
