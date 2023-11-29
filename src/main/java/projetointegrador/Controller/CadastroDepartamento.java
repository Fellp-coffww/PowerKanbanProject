
package projetointegrador.Controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.visual.HelloApplication;

import java.io.IOException;

public class CadastroDepartamento {

    private Quadro quadro;

    @FXML
    protected TextField nomeDep;

    @FXML
    protected Button buttonSalvar;

    @FXML
    protected Button buttonvoltar;

    @FXML
    protected void botaoVoltar(){
            Stage stage = (Stage) buttonvoltar.getScene().getWindow();
            stage.close();

    }
    @FXML
    protected void botaoSalvar(){

        quadro.getDepartamentos().add(nomeDep.getText());
        Stage stage = (Stage) buttonSalvar.getScene().getWindow();
        stage.close();

    }


    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }
}
