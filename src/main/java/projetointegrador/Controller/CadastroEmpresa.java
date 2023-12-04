package projetointegrador.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.visual.HelloApplication;

public class CadastroEmpresa {


    private Quadro quadro;


    @FXML
    protected TextField nomeEmp;

    @FXML
    protected Button buttonvoltar;

    @FXML
    protected Button buttonSalvar;


    @FXML
    protected void botaoSalvar(){

        if (nomeEmp.getText().equals("")){
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Não é possivel uma empresa sem nome");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();

            } catch (Exception e) {
                System.out.println(e);
            }
        }else {

            quadro.getEmpresas().add(nomeEmp.getText());
            Stage stage = (Stage) buttonSalvar.getScene().getWindow();
            stage.close();
        }
    }
    @FXML
    protected void botaoVoltar(){

        Stage stage = (Stage) buttonvoltar.getScene().getWindow();
        stage.close();
    }

    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }
}
