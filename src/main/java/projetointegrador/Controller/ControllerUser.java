package projetointegrador.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.Model.Entities.User;
import projetointegrador.visual.HelloApplication;
import projetointegrador.visual.HelloController;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerUser {


    private boolean OK;

    private boolean first = false;

    private ArrayList<User> lista = new ArrayList();

    private Quadro quadro = new Quadro();

    @FXML
    private TextField tnome;

    @FXML
    private PasswordField tpasswd;

    @FXML
    private Button bLogin;

    @FXML
    protected void onbLoginClick(){

        for(int n = 0; n<lista.size(); n++){

            if (tnome.getText().equals(lista.get(n).getName()) && tpasswd.getText().equals(lista.get(n).getPassword())){

                OK = true;

            }

        }
        if (OK){

            try {
                // Carregue o FXML da nova janela
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                Parent root = loader.load();

                // Passe a lista de projetos para o controlador da nova janela
                HelloController helloController = loader.getController();
                helloController.setQuadro(quadro);

                // Crie um novo Stage
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Main");
                novaJanela.setScene(new Scene(root));

                // Mostre a nova janela
                novaJanela.showAndWait();

                quadro = helloController.getQuadro();
            } catch (IOException e) {
                e.printStackTrace(); // Lida com a exceção adequadamente na sua aplicação
            }

        }

    }

    public boolean isOK() {
        return OK;
    }

    public void setOK(boolean OK) {
        this.OK = OK;
    }

    public ArrayList<User> getLista() {
        return lista;
    }

    public void setLista(ArrayList<User> lista) {
        this.lista = lista;
    }

    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }

    public void addUser(User user){

        lista.add(user);
    }

    @FXML
    protected void atualizaLista(){


        if (!first) {
            User user = new User("admin", "admin");
            lista.add(user);
        }
    }
}
