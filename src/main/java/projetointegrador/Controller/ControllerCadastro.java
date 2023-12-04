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

       if (TextoUsuarioCadastro.getText().equals("")){
           try {
               FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
               Parent root = loader.load();
               ControllerErro controllerErro = loader.getController();
               controllerErro.initialize("Preecha o nome do usuário");
               Stage novaJanela = new Stage();
               novaJanela.setTitle("Erro");
               novaJanela.setScene(new Scene(root));
               novaJanela.showAndWait();
           } catch (Exception e) {
               System.out.println(e);
           }

       } else if (SenhaCadastro.getText().equals("")) {
           try {
               FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
               Parent root = loader.load();
               ControllerErro controllerErro = loader.getController();
               controllerErro.initialize("Preecha a senha do usuário");
               Stage novaJanela = new Stage();
               novaJanela.setTitle("Erro");
               novaJanela.setScene(new Scene(root));
               novaJanela.showAndWait();
           } catch (Exception e) {
               System.out.println(e);
           }

       }
       else if (selectDepart.getSelectionModel().getSelectedItem() == null) {
           try {
               FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
               Parent root = loader.load();
               ControllerErro controllerErro = loader.getController();
               controllerErro.initialize("Preencha com um departamento! ");
               Stage novaJanela = new Stage();
               novaJanela.setTitle("Erro");
               novaJanela.setScene(new Scene(root));
               novaJanela.showAndWait();
           } catch (Exception e) {
               System.out.println(e);
           }

       } else {

           User user = new User(TextoUsuarioCadastro.getText(), SenhaCadastro.getText(), quadro.getDepartamentos().get(selectDepart.getSelectionModel().getSelectedIndex()));
           quadro.addUsers(user);

           Stage stage = (Stage) BotaoDeCadastro.getScene().getWindow();
           stage.close();
       }
    }


    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }
}
