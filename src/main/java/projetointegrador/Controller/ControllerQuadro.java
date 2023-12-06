package projetointegrador.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerQuadro {

    private ArrayList<Node> activeActions = new ArrayList<>();

    private ArrayList<String> adresses = new ArrayList<>();

    private Quadro quadro;

    private int index;


    @FXML
    protected Button buttonRmv;

    @FXML
    private  Label NomeProjeto;


    @FXML
    private ScrollPane aFazer;

    @FXML
    private ScrollPane sendoFeito;

    @FXML
    private ScrollPane Finalizado;

    @FXML
    private Label NomePercent;

    @FXML
    private Label Percent;

    @FXML
    private Label DataProjeto;

    private Pane paneAFazer = new Pane();
    private Pane paneFazendo = new Pane();

    private Pane paneFeito = new Pane();

    @FXML
    private BarChart GrafPercent;

    @FXML
    private BarChart GrafAtraso;

    protected void atualizaQuadro(){

    }

    public void initialize(Quadro quadro) {

        quadro = getQuadro();
        NomeProjeto.setText(quadro.retornaProjeto().get(index).getNome());
        DataProjeto.setText(quadro.retornaProjeto().get(index).retornaStringInicio() + " - " + quadro.retornaProjeto().get(index).retornaStringFim());
        NomePercent.setText(quadro.retornaProjeto().get(index).getNome());
        Percent.setText(Integer.toString(quadro.retornaProjeto().get(index).getPercentual()) + "%");
        graficoAtividades();
        generateActions();
        graficoAtraso();

    }

    protected void graficoAtividades(){
        atualizaPercentAtividade();
        GrafPercent.getData().clear();
        CategoryAxis EixoX = new CategoryAxis();
        NumberAxis EixoY = new NumberAxis();
        GrafPercent.setTitle("Atividades");
        XYChart.Series<String, Number> series =  new XYChart.Series<>();

        for (int atividade = 0 ; atividade < quadro.retornaProjeto().get(index).retornaAtividade().size(); atividade++){

            series.getData().add(new XYChart.Data<>(quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).getNome(), quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).getPercentual()));

        }

    GrafPercent.getData().add(series);

    }
    protected void graficoAtraso(){

        GrafAtraso.getData().clear();
        CategoryAxis EixoX = new CategoryAxis();
        NumberAxis EixoY = new NumberAxis();
        GrafAtraso.setTitle("Atrasos");
        XYChart.Series<String, Number> series =  new XYChart.Series<>();

        int atrasadas = 0;
        int noPrazo = 0;

        for(int n = 0; n< quadro.retornaProjeto().get(index).retornaAtividade().size(); n++){

            for (int x = 0; x < quadro.retornaProjeto().get(index).retornaAtividade().get(n).retornaAcao().size(); x++){
              if (quadro.retornaProjeto().get(index).retornaAtividade().get(n).retornaAcao().get(x).getAtrasao()){

                  atrasadas++;

              }else noPrazo++;
            }
            }

        series.getData().add(new XYChart.Data<>("Atradados", atrasadas));
        series.getData().add(new XYChart.Data<>("No prazo", noPrazo));

        GrafAtraso.getData().add(series);

    }

    protected void atualizaPercentAtividade(){

        int percentSoma = 0;
        int quant = 1;

        if (quadro.retornaProjeto().get(index).retornaAtividade().size() > 0) {

            for (int n = 0; n < quadro.retornaProjeto().get(index).retornaAtividade().size(); n++) {

                for (int x = 0; x < quadro.retornaProjeto().get(index).retornaAtividade().get(n).retornaAcao().size(); x++) {
                    percentSoma = percentSoma + quadro.retornaProjeto().get(index).retornaAtividade().get(n).retornaAcao().get(x).getPercentual();
                    quant++;
                }

                quadro.retornaProjeto().get(index).retornaAtividade().get(n).setPercentual(percentSoma / quant);
                percentSoma = 0;
                quant = 0;
            }
        }

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

        int somaPercentual =0;
        int soma = 0;


        int x =  0;
        int y1 = 0;
        int y2 = 0;
        int y3 = 0;

        paneAFazer.getChildren().clear();
        paneFeito.getChildren().clear();
        paneFazendo.getChildren().clear();

        paneAFazer.setPrefWidth(250);
        paneFeito.setPrefWidth(250);
        paneFazendo.setPrefWidth(250);

            for (int atividade  = 0; atividade< quadro.retornaProjeto().get(index).retornaAtividade().size(); atividade++){

                int somaAtividade = 0;
                int somaAtividadePercentual = 0;

                for (int acao = 0 ; acao < quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAção().size(); acao++){

                    somaAtividadePercentual  = somaAtividade +  quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getPercentual();
                    somaAtividade++;

                    if(quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getPercentual() == 0){

                        paneAFazer.setMaxWidth(y1);

                        int atraso = 0;

                        if (quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getDataDeInicio().isBefore(LocalDate.now())){
                            atraso = 1;
                        }

                        Pane Action = paneAcao((Acao) quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAção().get(acao),
                                x, y1,quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).getNome(), quadro.retornaProjeto().get(index).retornaAtividade()
                                        .get(atividade).getPercentual(), atraso);
                        somaPercentual = somaPercentual + quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getPercentual();
                        soma++;
                        activeActions.add(Action.getChildren().get(0));
                        paneAFazer.getChildren().add(Action);
                        adresses.add(Integer.toString(atividade) +"/"+ Integer.toString(acao));

                        y1 = y1 + 100;

                    } else if (quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getPercentual() > 0
                            && quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getPercentual() < 100) {

                        paneFazendo.setMaxWidth(y2);

                        int atraso = 0;

                        if (quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getDataDeInicio().isAfter(LocalDate.now())){
                            atraso = 1;
                        }
                        Pane Action = paneAcao((Acao) quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAção().get(acao),
                                x, y2,quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).getNome() ,quadro.retornaProjeto().get(index).retornaAtividade()
                                        .get(atividade).getPercentual(), atraso);

                        somaPercentual = somaPercentual + quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getPercentual();
                        soma++;

                        activeActions.add(Action.getChildren().get(0));

                        paneFazendo.getChildren().add(Action);
                        adresses.add(Integer.toString(atividade) +"/"+ Integer.toString(acao));

                        y2 = y2 + 100;


                    }else if(quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getPercentual() == 100) {

                        paneFeito.setMaxWidth(y3);
                        int atraso = 2;
                        Pane Action = paneAcao((Acao) quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAção().get(acao),
                                x, y3,quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).getNome(), quadro.retornaProjeto().get(index).retornaAtividade()
                                        .get(atividade).getPercentual(), atraso);

                        somaPercentual = somaPercentual + quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).retornaAcao().get(acao).getPercentual();
                        soma++;

                        activeActions.add(Action.getChildren().get(0));
                        adresses.add(Integer.toString(atividade) +"/"+ Integer.toString(acao));

                        paneFeito.getChildren().add(Action);

                        y3 = y3 + 100;
                    }

                }
              //  quadro.retornaProjeto().get(index).retornaAtividade().get(atividade).setPercentual(somaAtividadePercentual/somaAtividade);

            }
        aFazer.setContent(paneAFazer);
        sendoFeito.setContent(paneFazendo);
        Finalizado.setContent(paneFeito);
        if (soma != 0){
            quadro.retornaProjeto().get(index).setPercentual((somaPercentual / soma));
        }
    }

    public Pane paneAcao(Acao acao, int x, int y, String nomeAtividade, int percentAtv, int atraso){

        Pane pane = new Pane();
        pane.setLayoutX(x);
        pane.setLayoutY(y);
        pane.setPrefHeight(95);
        pane.setPrefWidth(250);

        Button button = new Button();
        Font.loadFont(getClass().getResourceAsStream("/fonts/Arial Black.ttf"), 12);
        button.setBackground(Background.fill(Paint.valueOf("yellow")));
        button.setStyle("-fx-background-radius: 20px");
        button.setStyle("-fx-font-family: ArialBlack");
        button.prefHeight(173);
        button.prefWidth(120);
        button.setPrefSize(193,80);
        button.setLayoutX(8);
        button.setLayoutY(19);
        button.setStyle("-fx-border-color:  #000000");
        button.setOnAction(this::editPercent);

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
        Label atividade = new Label(nomeAtividade +" - "+ percentAtv + "%");
        atividade.setLayoutX(14);
        atividade.setLayoutY(0);
        nomeResponsa.setText(acao.getNome()+" - " +acao.getDepartamento() + " - " +acao.getResponsavel() + " - "+ acao.getDataDeInicio().datesUntil(acao.getDataDeTermino()).count()+ " dias" );
        dataIn.setText(acao.retornaStringInicio());
        dataOut.setText(acao.retornaStringFim() +" - "+ acao.atualizaPercentualPorData()+"%");

        if(atraso == 0){
            status.setText("No prazo...");
        }
        else if (atraso == 1) {
            status.setText("Atrasado");
            status.setTextFill(Paint.valueOf("red"));
        } else if (atraso ==2) {
            status.setText("Finalizado");
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

    protected void editPercent(ActionEvent event){

        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaEditarPecent.fxml"));
            Parent root = loader.load();

            ControllerEditarAcao controllerEditarAcao = loader.getController();
            controllerEditarAcao.setQuadro(quadro);

            for (int n = 0; n < activeActions.size(); n++) {
                if (event.getSource().equals(activeActions.get(n))) {

                    Scanner sc = new Scanner(adresses.get(n)).useDelimiter("/");
                    controllerEditarAcao.setIndexAtv(sc.nextInt());
                    controllerEditarAcao.setIndexAction(sc.nextInt());

                }
            }

            controllerEditarAcao.setIndexPrj(index);
            controllerEditarAcao.initialize();
            Stage novaJanela = new Stage();
            novaJanela.setTitle("Edição de Ações");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();
            initialize(quadro);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void editProjeto(){

        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("TelaCadastroDeProjetos.fxml"));
            Parent root = loader.load();

            int comboxEmp = 0;

            CadastroProjeto cadastroProjeto = loader.getController();
            cadastroProjeto.setQuadro(quadro);

            for (int n = 0; n< quadro.getUsers().size(); n++){
                if(quadro.retornaProjeto().get(index).getEmpresa().equals(quadro.getEmpresas().get(n))){
                    comboxEmp = n;
                }
            }
            cadastroProjeto.tNomeP.setText(quadro.retornaProjeto().get(index).getNome());
            cadastroProjeto.tDataFinalP.setValue(quadro.retornaProjeto().get(index).getDataDeTermino());
            cadastroProjeto.tDatainicioP.setValue(quadro.retornaProjeto().get(index).getDataDeInicio());
            cadastroProjeto.comBoxE.getSelectionModel().select(comboxEmp);
            cadastroProjeto.setOrigin(index);

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Projetos");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();

            initialize(cadastroProjeto.getQuadro());
            quadro = cadastroProjeto.getQuadro();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void editAtv(){
    
        
    }

    @FXML
    protected void rmvAcao(){

        quadro.retornaProjeto().remove(index);
        Stage stage = (Stage) buttonRmv.getScene().getWindow();
        stage.close();
    }


}
