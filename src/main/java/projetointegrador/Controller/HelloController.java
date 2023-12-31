package projetointegrador.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.visual.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController {

    private ArrayList<Button> listaBotao = new ArrayList<>();

    private Quadro quadro = new Quadro(); // Objeto Quadro

    // Método getter e setter para o objeto Quadro
    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }

    // Referências aos elementos da interface gráfica (FXML)
    @FXML
    protected Button projeto01;

    @FXML
    protected Button projeto02;

    @FXML
    protected Button projeto03;

    @FXML
    protected Pane panezona;

    @FXML
    protected MenuButton bottonMenu;

    @FXML
    protected MenuItem altDept;

    @FXML
    protected MenuItem altColab;



    // Método acionado ao clicar para abrir a janela de cadastro de Ação

    @FXML
    protected void janelaColaborador() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("telacadastroUsuario.fxml"));
            Parent root = loader.load();

            ControllerCadastro controllerCadastro = loader.getController();
            controllerCadastro.inicializa(quadro);
            controllerCadastro.setQuadro(quadro);

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de colaborador");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();

            quadro = controllerCadastro.getQuadro();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void janelaDepartamento() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("janelaCadastroDepartamento.fxml"));
            Parent root = loader.load();

            CadastroDepartamento cadastroDepartamento = loader.getController();
            cadastroDepartamento.setQuadro(quadro);

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de colaborador");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();

            quadro = cadastroDepartamento.getQuadro();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToQuadro(MouseEvent event) {
        try {
            quadro = getQuadro();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("janelaQuadro.fxml"));
            Parent root = loader.load();

            ControllerQuadro controllerQuadro = loader.getController();
            controllerQuadro.setQuadro(getQuadro());
            for (int n = 0; n < listaBotao.size(); n++) {
                if (event.getSource().equals(listaBotao.get(n))) {
                    controllerQuadro.setIndex(n);
                }
            }

            controllerQuadro.initialize(quadro);
            Stage novaJanela = new Stage();
            novaJanela.setTitle("Quadro principal");
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            quadro = controllerQuadro.getQuadro();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Método acionado ao clicar para abrir a janela de cadastro de Projeto
    @FXML
    protected void onbJanelaClick1() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("TelaCadastroDeProjetos.fxml"));
            Parent root = loader.load();

            CadastroProjeto cadastroProjeto = loader.getController();
            cadastroProjeto.setQuadro(quadro);
            cadastroProjeto.AtualizaComboBoxE();

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Projetos");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();
            testeBotao(quadro);

            quadro = cadastroProjeto.getQuadro();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método acionado ao clicar para abrir a janela de cadastro de Atividade


    @FXML
    protected void testeBotao(Quadro quadro) {
        this.quadro = quadro;

        listaBotao.clear();
        int Posx[] = {60, 284, 516};
        int Posy[] = {132, 266, 392};
        int x = 0;
        int y = 0;

        for (int n = 0; n < this.quadro.retornaProjeto().size(); n++) {

            if (x > 2) {
                y++;
                x = 0;
            }
            Button button = addButtonProjeto(this.quadro.retornaProjeto().get(n), Posx[x], Posy[y]);
            button.setId(Integer.toString(n));
            listaBotao.add(button);
            panezona.getChildren().add(button);
            x++;
        }
    }

    protected Button addButtonProjeto(Projeto projeto, int x, int y) {

        Button button = new Button();
        button.setText(projeto.getNome());
        Font.loadFont(getClass().getResourceAsStream("/fonts/Arial Black.ttf"), 12);
        button.setBackground(Background.fill(Paint.valueOf("orange")));
        button.setTextFill(Paint.valueOf("WHITE"));
        // button.setStyle("-fx-background-radius: 20px");
        button.setStyle("-fx-font-family: ArialBlack");
        button.setPrefHeight(64);
        button.setPrefWidth(160);
        button.setLayoutY(y);
        button.setLayoutX(x);
        button.setOnMouseClicked(this::goToQuadro);
        return button;

    }

    @FXML
    protected void botaoVolta() {

        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("janelaLoginUsuario.fxml"));
            Parent root = loader.load();

            ControllerUser cadastroProjeto = loader.getController();
            cadastroProjeto.setQuadro(quadro);

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Login");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();
            testeBotao(quadro);

            quadro = cadastroProjeto.getQuadro();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void janelaEmpresa(){

        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("janelaCadastroEmpresa.fxml"));
            Parent root = loader.load();

            CadastroEmpresa cadastroEmpresa = loader.getController();
            cadastroEmpresa.setQuadro(quadro);

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Login");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();

            quadro = cadastroEmpresa.getQuadro();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}