package projetointegrador.visual;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projetointegrador.Controller.ControllerUser;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.Model.Entities.User;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Quadro quadro = new Quadro();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("janelaLoginUsuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}