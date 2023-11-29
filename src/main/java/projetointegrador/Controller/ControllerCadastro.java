package projetointegrador.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.Model.Entities.User;
import projetointegrador.visual.HelloApplication;

import java.io.IOException;

public class ControllerCadastro {


    private Quadro quadro = new Quadro();

    @FXML
    private TextField TextoUsuarioCadastro;

    @FXML
    private ComboBox selectDepart;

    @FXML
    private PasswordField SenhaCadastro;

    @FXML
    private Button BotaoDeCadastro;


   public void inicializa(Quadro quadro){

        ObservableList<String> observableListDep;
        observableListDep = FXCollections.observableArrayList(quadro.getDepartamentos());
        selectDepart.setItems(observableListDep);
    }

    @FXML
    protected void ClickDoBotao(){

        User user = new User(TextoUsuarioCadastro.getText(), SenhaCadastro.getText(), quadro.getDepartamentos().get(selectDepart.getSelectionModel().getSelectedIndex()));
        quadro.addUsers(user);

        Stage stage = (Stage) BotaoDeCadastro.getScene().getWindow();
        stage.close();
     /*   try {
            // Carrega o FXML da nova janela
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("janelaLoginUsuario.fxml"));
            Parent root = loader.load();

            // Passa o Quadro para o controlador da nova janela
            ControllerUser helloController = loader.getController();
            helloController.setQuadro(quadro);

            // Cria um novo Stage
            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro");
            novaJanela.setScene(new Scene(root));

            // Mostra a nova janela
            novaJanela.show();

            Stage stage = (Stage) BotaoDeCadastro.getScene().getWindow();
            stage.close();

            // Atualiza o quadro com as alterações feitas na janela
            quadro = helloController.getQuadro();
        } catch (IOException e) {
            e.printStackTrace(); // Lida com a exceção adequadamente na sua aplicação
        }
    */
    }


    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }
}
