package projetointegrador.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.Atividade;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Quadro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Controlador para a interface de cadastro de atividades
public class CadastroAtividade {

    // Objeto Quadro
    private Quadro quadro = new Quadro();

    // Referências aos elementos da interface gráfica (FXML)
    @FXML
    private Button onbSaveA; // Botão para salvar atividade

    @FXML
    private ComboBox<Projeto> comBox; // ComboBox para seleção de projeto

    @FXML
    private TextField tNomeA; // Campo de texto para o nome da atividade

    @FXML
    private TextField tDatainicioA; // Campo de texto para a data de início da atividade

    @FXML
    private TextField tDataFinalA; // Campo de texto para a data de finalização da atividade

    // Método para atualizar o ComboBox com os projetos disponíveis
    @FXML
    protected void atualizaComboBox() {
        ObservableList<Projeto> observableList;
        observableList = FXCollections.observableArrayList(quadro.retornaProjeto());
        comBox.setItems(observableList);
    }

    // Método para salvar a atividade associada ao projeto selecionado
    @FXML
    protected void saveAtividade() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate DatadeInicio = LocalDate.parse(tDatainicioA.getText(), dtf);
        LocalDate DatadeFinalizacao = LocalDate.parse(tDataFinalA.getText(), dtf);
        String nome = tNomeA.getText();
        Atividade atividade = new Atividade(DatadeInicio, DatadeFinalizacao, nome);
        quadro.retornaProjeto().get(comBox.getSelectionModel().getSelectedIndex()).addObject(atividade);
        Stage stage = (Stage) onbSaveA.getScene().getWindow();
        stage.close();
    }

    // Getters e setters para o objeto Quadro
    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }
}
