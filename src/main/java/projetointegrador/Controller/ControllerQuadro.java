package projetointegrador.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.visual.HelloApplication;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerQuadro implements Initializable {



    private Quadro quadro;


    @FXML
    private SubScene acao01;

    protected void atualizaQuadro(){



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }
}
