package projetointegrador.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import projetointegrador.Model.Entities.Atividade;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Quadro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroAtividade {


    private Quadro quadro = new Quadro();

    @FXML
    private Button onbSaveA;

    @FXML
    private ComboBox<Projeto> comBox;

    @FXML
    private TextField tNomeA;


    @FXML
    private TextField tDatainicioA;


    @FXML
    private TextField tDataFinalA;


    @FXML
    protected void atualizaComboBox(){

        System.out.println(quadro.retornaProjeto().size());
        ObservableList<Projeto> observableList;
        observableList = FXCollections.observableArrayList(quadro.retornaProjeto());
        comBox.setItems(observableList);
    }

    @FXML
    protected void saveAtividade(){

        System.out.println(comBox.getSelectionModel().getSelectedIndex());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate DatadeInicio = LocalDate.parse(tDatainicioA.getText(), dtf);
        LocalDate DatadeFinalizacao = LocalDate.parse(tDataFinalA.getText(),dtf);
        String nome = tNomeA.getText();
        Atividade atividade = new Atividade(DatadeInicio,DatadeFinalizacao,nome);
        quadro.retornaProjeto().get(comBox.getSelectionModel().getSelectedIndex()).addObject(atividade);


    }


    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }


}
