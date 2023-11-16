package projetointegrador.visual;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.collections.*;
import projetointegrador.Controller.CadastroAcao;
import projetointegrador.Controller.CadastroAtividade;
import projetointegrador.Controller.CadastroProjeto;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.visual.ListsToControler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HelloController {

    private  Quadro quadro = new Quadro();


    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }


    @FXML
    private ComboBox<Projeto> comBox;


    @FXML
    private TextField tDatainicio;

    @FXML
    private TextField tDataFinal;

    @FXML
    private TextField tResponsavel;

    @FXML
    private TextField tNome;



    @FXML
    protected void onbJanelaClick(){
        try {
            // Carregue o FXML da nova janela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("janelaCadastroAcao.fxml"));
            Parent root = loader.load();

            // Passe a lista de projetos para o controlador da nova janela
            CadastroAcao cadastroAcao = loader.getController();
            cadastroAcao.setQuadro(quadro);

            // Crie um novo Stage
            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Projetos");
            novaJanela.setScene(new Scene(root));

            // Mostre a nova janela
            novaJanela.showAndWait();

            quadro = cadastroAcao.getQuadro();
        } catch (IOException e) {
            e.printStackTrace(); // Lida com a exceção adequadamente na sua aplicação
        }
    }

    @FXML
    protected void onbJanelaClick1(){
        try {
            // Carregue o FXML da nova janela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("janelaCadastroProjeto.fxml"));
            Parent root = loader.load();

            // Passe a lista de projetos para o controlador da nova janela
            CadastroProjeto cadastroProjeto = loader.getController();
            cadastroProjeto.setQuadro(quadro);

            // Crie um novo Stage
            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Projetos");
            novaJanela.setScene(new Scene(root));

            // Mostre a nova janela
            novaJanela.showAndWait();

            quadro = cadastroProjeto.getQuadro();
        } catch (IOException e) {
            e.printStackTrace(); // Lida com a exceção adequadamente na sua aplicação
        }
    }



    @FXML
    private void onbJanelaClick2(){
        try {
            // Carregue o FXML da nova janela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("janelaCadastroAtividade.fxml"));
            Parent root = loader.load();

            // Passe a lista de projetos para o controlador da nova janela
            CadastroAtividade cadastroAtividade = loader.getController();
            cadastroAtividade.setQuadro(quadro);

            // Crie um novo Stage
            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Projetos");
            novaJanela.setScene(new Scene(root));

            // Mostre a nova janela
            novaJanela.showAndWait();

            quadro = cadastroAtividade.getQuadro();
            System.out.println(quadro.retornaProjeto().get(0).retornaAtividade().size());
        } catch (IOException e) {
            e.printStackTrace(); // Lida com a exceção adequadamente na sua aplicação
        }

    }

}