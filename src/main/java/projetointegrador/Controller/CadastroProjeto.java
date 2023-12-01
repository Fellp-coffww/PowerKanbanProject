package projetointegrador.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private TextField tDatainicioP; // Campo de texto para a data de início do projeto

    @FXML
    private TextField tDataFinalP; // Campo de texto para a data de finalização do projeto


    @FXML
    private TextField tNomeP; // Campo de texto para o nome do projeto

    @FXML
    private Button BotaoFecharAba;

    LocalDate DatadeInicio;
    LocalDate DatadeFinalizacao;

    // Método acionado ao clicar no botão para salvar projeto
    @FXML
    private void onbSavePClick() throws IOException {
        // Obtendo as informações dos campos de texto

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DatadeInicio = LocalDate.parse(tDatainicioP.getText(), dtf);
            DatadeFinalizacao = LocalDate.parse(tDataFinalP.getText(), dtf);
            String nome = tNomeP.getText();

            // Criando um novo projeto com os dados inseridos
            Projeto projeto = new Projeto(DatadeInicio, DatadeFinalizacao, nome);

            // Adicionando o projeto ao Quadro
            quadro.addObject(projeto);

            // Fechando a janela atual
            Stage stage = (Stage) onbSaveP.getScene().getWindow();
            stage.close();

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("TelaErro.fxml"));
            Parent root = loader.load();
            ControllerErro controllerErro = loader.getController();
            controllerErro.initialize("Verifique as data de inicio e fim!");
            Stage novaJanela = new Stage();
            novaJanela.setTitle("Erro");
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

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
}
