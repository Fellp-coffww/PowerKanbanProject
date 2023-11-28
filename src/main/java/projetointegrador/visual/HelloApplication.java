package projetointegrador.visual;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projetointegrador.Controller.CadastroAcao;
import projetointegrador.Controller.ControllerQuadro;
import projetointegrador.Controller.ControllerUser;
import projetointegrador.Model.Entities.*;

import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Quadro quadro = new Quadro();
        quadro.addUsers(new User("admin","admin", ""));
        quadro.addObject(new Projeto(LocalDate.now(), LocalDate.now(),"projeto01"));
        quadro.addObject(new Projeto(LocalDate.now(), LocalDate.now(),"projeto02"));
        quadro.addObject(new Projeto(LocalDate.now(), LocalDate.now(),"projeto03"));
        quadro.addObject(new Projeto(LocalDate.now(), LocalDate.now(),"projeto04"));
        quadro.retornaProjeto().get(0).addObject(new Atividade(LocalDate.now(),LocalDate.now(), "Atividade 01"));
        quadro.retornaProjeto().get(1).addObject(new Atividade(LocalDate.now(),LocalDate.now(), "Atividade 02"));
        quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Acao(LocalDate.now(),LocalDate.now(), "Açao01","Fellipe","TI"));
        quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Acao(LocalDate.now(),LocalDate.now(), "Açao01","Fellipe","TI"));
        quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Acao(LocalDate.now(),LocalDate.now(), "Açao01","Fellipe","TI"));
        quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Acao(LocalDate.now(),LocalDate.now(), "Açao01","Fellipe","TI"));
        quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Acao(LocalDate.now(),LocalDate.now(), "Açao01","Fellipe","TI"));
        quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Acao(LocalDate.now(),LocalDate.now(), "Açao01","Fellipe","TI"));
        quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Acao(LocalDate.now(),LocalDate.now(), "Açao01","Fellipe","TI"));
        quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Acao(LocalDate.now(),LocalDate.now(), "Açao01","Fellipe","TI"));
        quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Acao(LocalDate.now(),LocalDate.now(), "Açao01","Fellipe","TI"));



        /*
         * Teste de funcionalidade
         *
         *
         * */
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("janelaLoginUsuario.fxml"));
        Parent root = loader.load();
        ControllerUser controllerUser = loader.getController();
        controllerUser.setQuadro(quadro);
        controllerUser.setLista(quadro.getUsers());
        Stage novaJanela = new Stage();
        stage.setTitle("Login");
        novaJanela.setScene(new Scene(root));
        novaJanela.setTitle("Login");
        novaJanela.showAndWait();
        
    }

    public static void main(String[] args) {
        launch();
        System.out.println("oi");
    }
}