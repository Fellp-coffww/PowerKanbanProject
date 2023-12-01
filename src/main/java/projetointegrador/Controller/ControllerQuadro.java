package projetointegrador.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.Acao;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.visual.HelloApplication;

import java.io.IOException;
import java.time.LocalDate;

public class ControllerQuadro {

    private Quadro quadro;

    private int index;


    @FXML
    private  Label NomeProjeto;


    @FXML
    private ScrollPane aFazer;

    @FXML
    private ScrollPane sendoFeito;

    @FXML
    private ScrollPane Finalizado;


    private Pane paneAFazer = new Pane();
    private Pane paneFazendo = new Pane();

    private Pane paneFeito = new Pane();

    protected void atualizaQuadro(){

    }

    public void initialize(Quadro quadro) {
        quadro = getQuadro();
        generateActions();
        NomeProjeto.setText(quadro.retornaProjeto().get(index).getNome());

    }

    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }
    @FXML
    protected void addAtv(){
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("janelaCadastroAtividade.fxml"));
            Parent root = loader.load();

            CadastroAtividade cadastroProjeto = loader.getController();
            cadastroProjeto.setQuadro(quadro);
            cadastroProjeto.setIndex(index);

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de atividades");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();

            quadro = cadastroProjeto.getQuadro();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void addAcao(){
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("janelaCadastroAçao.fxml"));
            Parent root = loader.load();

            CadastroAcao cadastroAcao = loader.getController();
            cadastroAcao.setQuadro(quadro);
            cadastroAcao.setIndex(index);
            cadastroAcao.incializa();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Ações");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();

            generateActions();
            quadro = cadastroAcao.getQuadro();
            System.out.println(quadro.retornaProjeto().get(0).retornaAtividade().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private void generateActions(){

        int x =  0;
        int y1 = 0;
        int y2 = 0;
        int y3 = 0;

        paneAFazer.setPrefWidth(200);

            for (int atividade  = 0; atividade< quadro.retornaProjeto().get(index).retornaAtividade().size(); atividade++){

                for (int acao = 0 ; acao < quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAção().size(); acao++){
                    if(quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getPercentual() == 0){

                        paneAFazer.setMaxWidth(y1);

                        paneAFazer.getChildren().add(paneAcao((Acao) quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAção().get(acao),
                                x, y1,quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).getNome()));

                        y1 = y1 + 100;

                    } else if (quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getPercentual() > 0
                            && quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getPercentual() < 100) {

                        paneFazendo.setMaxWidth(y2);

                        paneFazendo.getChildren().add(paneAcao((Acao) quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAção().get(acao)
                                ,x, y2,quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).getNome()));

                        y2 = y2 + 100;


                    }else if(quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getPercentual() == 100) {

                        paneFeito.setMaxWidth(y3);

                        paneFeito.getChildren().add(paneAcao((Acao) quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAção().get(acao)
                                ,x, y3,quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).getNome()));

                        y3 = y3 + 100;
                    }

                }
            }


        aFazer.setContent(paneAFazer);
        sendoFeito.setContent(paneFazendo);
        Finalizado.setContent(paneFeito);
    }

    public Pane paneAcao(Acao acao, int x, int y, String nomeAtividade){

        Pane pane = new Pane();
        pane.setLayoutX(x);
        pane.setLayoutY(y);
        pane.setPrefHeight(95);
        pane.setPrefWidth(200);

        Button button = new Button();
        Font.loadFont(getClass().getResourceAsStream("/fonts/Arial Black.ttf"), 12);
        button.setBackground(Background.fill(Paint.valueOf("yellow")));
        button.setStyle("-fx-background-radius: 20px");
        button.setStyle("-fx-font-family: ArialBlack");
        button.prefHeight(173);
        button.prefWidth(71);
        button.setPrefSize(173,71);
        button.setLayoutX(8);
        button.setLayoutY(19);
        button.setStyle("-fx-border-color:  #000000");


        Label nomeResponsa = new Label();
        nomeResponsa.setLayoutX(17);
        nomeResponsa.setLayoutY(24);
        nomeResponsa.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 12));
        Label dataIn = new Label();
        dataIn.setLayoutX(16);
        dataIn.setLayoutY(45);
        Label dataOut = new Label();
        dataOut.setLayoutX(83);
        dataOut.setLayoutY(45);
        Label status = new Label();
        status.setLayoutX(16);
        status.setLayoutY(67);
        Label percent = new Label();
        percent.setLayoutX(150);
        percent.setLayoutY(70);
        percent.setText(String.valueOf(acao.getPercentual()) + "%");
        Label atividade = new Label(nomeAtividade);
        atividade.setLayoutX(14);
        atividade.setLayoutY(0);
        nomeResponsa.setText(acao.getNome()+" - " +acao.getResponsavel());
        dataIn.setText(acao.retornaStringInicio());
        dataOut.setText(acao.retornaStringFim());

        if(acao.getDataDeTermino().isBefore(LocalDate.now())){
            status.setText("No prazo...");
        }
        else {
            status.setText("Atrasado");
            status.setTextFill(Paint.valueOf("red"));

        }
        pane.getChildren().add(button);
        pane.getChildren().add(nomeResponsa);
        pane.getChildren().add(dataIn);
        pane.getChildren().add(dataOut);
        pane.getChildren().add(status);
        pane.getChildren().add(atividade);
        pane.getChildren().add(percent);


        return pane;


    }


}
