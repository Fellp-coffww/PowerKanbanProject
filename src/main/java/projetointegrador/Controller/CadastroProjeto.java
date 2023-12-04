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
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.visual.HelloApplication;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Controlador para a interface de cadastro de projetos
public class CadastroProjeto {

    // Objeto Quadro
    private Quadro quadro = new Quadro();

    // Referências aos elementos da interface gráfica (FXML)
    @FXML
    private Button onbSaveP; // Botão para salvar projeto

    @FXML
    protected DatePicker tDatainicioP; // Campo de texto para a data de início do projeto

    @FXML
    protected DatePicker tDataFinalP; // Campo de texto para a data de finalização do projeto


    @FXML
    protected TextField tNomeP; // Campo de texto para o nome do projeto

    @FXML
    private Button BotaoFecharAba;

    @FXML
    protected ComboBox comBoxE;

    LocalDate DatadeInicio;
    LocalDate DatadeFinalizacao;

    private int origin = 999;

    // Método acionado ao clicar no botão para salvar projeto
    @FXML
    private void onbSavePClick() throws IOException {
        // Obtendo as informações dos campos de texto

        try {
            DatadeInicio = tDatainicioP.getValue();
            DatadeFinalizacao = tDataFinalP.getValue();
            String nome = tNomeP.getText();

            if (nome.equals("")) {
                try {
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                    Parent root = loader.load();
                    ControllerErro controllerErro = loader.getController();
                    controllerErro.initialize("Não é possivel um projeto sem nome");
                    Stage novaJanela = new Stage();
                    novaJanela.setTitle("Erro");
                    novaJanela.setScene(new Scene(root));
                    novaJanela.showAndWait();
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (DatadeInicio == null || DatadeFinalizacao == null) {
                try {
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                    Parent root = loader.load();
                    ControllerErro controllerErro = loader.getController();
                    controllerErro.initialize("Datas não podem ser nulas");
                    Stage novaJanela = new Stage();
                    novaJanela.setTitle("Erro");
                    novaJanela.setScene(new Scene(root));
                    novaJanela.showAndWait();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
                else if (DatadeFinalizacao.isBefore(DatadeInicio)) {
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
                } else if (comBoxE.getSelectionModel().getSelectedItem() == null) {
                try {
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                    Parent root = loader.load();
                    ControllerErro controllerErro = loader.getController();
                    controllerErro.initialize("Selecione uma empresa");
                    Stage novaJanela = new Stage();
                    novaJanela.setTitle("Erro");
                    novaJanela.setScene(new Scene(root));
                    novaJanela.showAndWait();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
              else {

                // Criando um novo projeto com os dados inseridos
                Projeto projeto = new Projeto(DatadeInicio, DatadeFinalizacao, nome);

                if (origin == 999) {
                    // Adicionando o projeto ao Quadro
                    quadro.addObject(projeto);
                }
                else {

                    quadro.retornaProjeto().get(origin).setNome(nome);
                    quadro.retornaProjeto().get(origin).setDataDeInicio(DatadeInicio);
                    quadro.retornaProjeto().get(origin).setDataDeTermino(DatadeFinalizacao);
                }
                // Fechando a janela atual
                Stage stage = (Stage) onbSaveP.getScene().getWindow();
                stage.close();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }}



    // Getters e setters para o objeto Quadro
    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }
    @FXML
    protected void BotaoVoltar(){

        Stage stage = (Stage) BotaoFecharAba.getScene().getWindow();
        stage.close();

    }

    @FXML
    protected void AtualizaComboBoxE(){

        ObservableList<String> observableListDep;
        observableListDep = FXCollections.observableArrayList(quadro.getEmpresas());
        comBoxE.setItems(observableListDep);

    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }
}
