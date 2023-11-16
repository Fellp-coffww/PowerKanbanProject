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

// Controlador para operações relacionadas ao usuário na interface
public class ControllerUser {

    private boolean OK; // Flag para verificar se o login foi bem-sucedido
    private boolean first = false; // Flag para indicar se é a primeira execução
    private ArrayList<User> lista = new ArrayList<>(); // Lista de usuários
    private Quadro quadro = new Quadro(); // Objeto Quadro

    // Referências aos elementos da interface gráfica (FXML)
    @FXML
    private TextField tnome; // Campo de texto para o nome do usuário

    @FXML
    private PasswordField tpasswd; // Campo de texto para a senha do usuário

    @FXML
    private Button bLogin; // Botão de login

    // Método acionado ao clicar no botão de login
    @FXML
    protected void onbLoginClick() {
        for (int n = 0; n < lista.size(); n++) {
            if ((tnome.getText().equals(lista.get(n).getName())) && tpasswd.getText().equals(lista.get(n).getPassword())) {
                OK = true; // Define OK como verdadeiro se as credenciais coincidirem
            }
        }
        if (OK) {
            try {
                // Carrega o FXML da nova janela
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                Parent root = loader.load();

                // Passa o Quadro para o controlador da nova janela
                HelloController helloController = loader.getController();
                helloController.setQuadro(quadro);

                // Cria um novo Stage
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Main");
                novaJanela.setScene(new Scene(root));

                // Mostra a nova janela
                novaJanela.showAndWait();

                // Atualiza o quadro com as alterações feitas na janela
                quadro = helloController.getQuadro();
            } catch (IOException e) {
                e.printStackTrace(); // Lida com a exceção adequadamente na sua aplicação
            }
        }
    }

    // Getters e setters para os atributos do controlador
    // Métodos para manipulação da lista de usuários e quadro
    // Método para adicionar um usuário à lista
    public void addUser(User user) {
        lista.add(user);
    }

    // Método para inicializar a lista com um usuário administrativo se for a primeira execução
    @FXML
    protected void atualizaLista() {
        if (!first) {
            User user = new User("admin", "admin");
            lista.add(user);
        }
    }

    // Getters e setters para os atributos do controlador
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
}
