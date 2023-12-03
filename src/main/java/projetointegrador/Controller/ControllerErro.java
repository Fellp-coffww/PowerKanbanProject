package projetointegrador.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerErro {

    private String erro = "";

    @FXML
    protected Button fechar;

    @FXML
    protected Label Msg;


    protected void initialize(String description){

        Msg.setText(description);

    }

    @FXML
    protected void close(){

        Stage stage = (Stage) fechar.getScene().getWindow();
        stage.close();

    }





}
