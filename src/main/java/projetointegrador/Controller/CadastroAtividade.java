package projetointegrador.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.Atividade;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.visual.HelloApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

// Controlador para a interface de cadastro de atividades
public class CadastroAtividade {

    // Objeto Quadro
    private Quadro quadro = new Quadro();

    private int index;

    // Referências aos elementos da interface gráfica (FXML)
    @FXML
    private Button onbSaveA; // Botão para salvar atividade

    @FXML
    private Button  bclickVoltar;

    @FXML
    private TextField tNomeA; // Campo de texto para o nome da atividade

    @FXML
    private DatePicker tDatainicioA; // Campo de texto para a data de início da atividade

    @FXML
    private DatePicker tDataFinalA; // Campo de texto para a data de finalização da atividade

    // Método para atualizar o ComboBox com os projetos disponíveis

    // Método para salvar a atividade associada ao projeto selecionado
    @FXML
    protected void saveAtividade() {

        LocalDate DatadeInicio = tDatainicioA.getValue();
        LocalDate DatadeFinalizacao = tDataFinalA.getValue();
        String nome = tNomeA.getText();


        if (tNomeA.getText().equals("")){
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Não é possivel uma atividade sem nome.");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (DatadeInicio == null ){
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Verifique as datas de inicio.");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if ((DatadeInicio.isBefore(quadro.retornaProjeto().get(index).getDataDeInicio()))) {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Data de inicio da atividade não pode ser menor que a data de inicio do projeto.");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (DatadeFinalizacao == null ) {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Verifique as datas de fim.");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (DatadeFinalizacao.isAfter(quadro.retornaProjeto().get(index).getDataDeTermino())){
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Data final da atividade não pode ser maior que a data final do projeto.");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (DatadeFinalizacao.isBefore(DatadeInicio)) {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Data de finalização não pode ser antes que a data de inicio ");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }else {

            Atividade atividade = new Atividade(DatadeInicio, DatadeFinalizacao, nome);
            quadro.retornaProjeto().get(index).addObject(atividade);
            Stage stage = (Stage) onbSaveA.getScene().getWindow();
            stage.close();
        }
    }

    // Getters e setters para o objeto Quadro
    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }
    @FXML
    protected void botaoVoltar(){

        Stage stage = (Stage) bclickVoltar.getScene().getWindow();
        stage.close();


    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

