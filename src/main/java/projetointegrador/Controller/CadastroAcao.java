package projetointegrador.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.DepthTest;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.Atividade;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Quadro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroAcao {

    private Quadro quadro = new Quadro();

    @FXML
    private ComboBox comBoxP;

    @FXML
    private ComboBox comBoxA;

    @FXML
    private TextField tDatainicio;

    @FXML
    private TextField tDataFinal;

    @FXML
    private TextField tNome;

    @FXML
    private TextField tResponsavel;

    @FXML Button bSave;


    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }

    @FXML
    protected void AtualizaComboBoxP(){
        ObservableList<Projeto> observableList;
        observableList = FXCollections.observableArrayList(quadro.retornaProjeto());
        comBoxP.setItems(observableList);
    }

    @FXML
    protected void habilitaComboBoxA(){

        if (comBoxP.getItems().size() > 0){

            comBoxA.depthTestProperty().set(DepthTest.ENABLE);

        }

    }

    @FXML
    protected void AtualizaComboBoxA(){
        ObservableList<Atividade> observableList;
        observableList = FXCollections.observableArrayList(quadro.retornaProjeto().get(comBoxP.getSelectionModel().getSelectedIndex()).retornaAtividade());
        comBoxA.setItems(observableList);
    }


}
