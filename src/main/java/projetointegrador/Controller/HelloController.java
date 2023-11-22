package projetointegrador.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import projetointegrador.Controller.CadastroAcao;
import projetointegrador.Controller.CadastroAtividade;
import projetointegrador.Controller.CadastroProjeto;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Quadro;
import java.io.IOException;

public class HelloController {

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



    // Método acionado ao clicar para abrir a janela de cadastro de Ação
    @FXML
    protected void onbJanelaClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("janelaCadastroAcao.fxml"));
            Parent root = loader.load();

            CadastroAcao cadastroAcao = loader.getController();
            cadastroAcao.setQuadro(quadro);

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Ações");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();

            quadro = cadastroAcao.getQuadro();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método acionado ao clicar para abrir a janela de cadastro de Projeto
    @FXML
    protected void onbJanelaClick1() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("janelaCadastroProjeto.fxml"));
            Parent root = loader.load();

            CadastroProjeto cadastroProjeto = loader.getController();
            cadastroProjeto.setQuadro(quadro);

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Projetos");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();

            quadro = cadastroProjeto.getQuadro();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método acionado ao clicar para abrir a janela de cadastro de Atividade
    @FXML
    private void onbJanelaClick2() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("janelaCadastroAtividade.fxml"));
            Parent root = loader.load();

            CadastroAtividade cadastroAtividade = loader.getController();
            cadastroAtividade.setQuadro(quadro);

            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Atividades");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();

            quadro = cadastroAtividade.getQuadro();
            System.out.println(quadro.retornaProjeto().get(0).retornaAtividade().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
