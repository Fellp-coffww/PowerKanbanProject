package projetointegrador.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Quadro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Controlador para a interface de cadastro de projetos
public class CadastroProjeto {

    // Objeto Quadro
    private Quadro quadro = new Quadro();

    // Referências aos elementos da interface gráfica (FXML)
    @FXML
    private Button onbSaveP; // Botão para salvar projeto

    @FXML
    private TextField tDatainicioP; // Campo de texto para a data de início do projeto

    @FXML
    private TextField tDataFinalP; // Campo de texto para a data de finalização do projeto

    @FXML
    private TextField tResponsavelP; // Campo de texto para o responsável pelo projeto

    @FXML
    private TextField tNomeP; // Campo de texto para o nome do projeto

    // Método acionado ao clicar no botão para salvar projeto
    @FXML
    private void onbSavePClick() {
        // Obtendo as informações dos campos de texto
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate DatadeInicio = LocalDate.parse(tDatainicioP.getText(), dtf);
        LocalDate DatadeFinalizacao = LocalDate.parse(tDataFinalP.getText(), dtf);
        String nome = tNomeP.getText();

        // Criando um novo projeto com os dados inseridos
        Projeto projeto = new Projeto(DatadeInicio, DatadeFinalizacao, nome);

        // Adicionando o projeto ao Quadro
        quadro.addObject(projeto);

        // Imprimindo informações de teste
        System.out.println(projeto);
        System.out.println(quadro.retornaProjeto().size());

        // Fechando a janela atual
        Stage stage = (Stage) onbSaveP.getScene().getWindow();
        stage.close();
    }

    // Getters e setters para o objeto Quadro
    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }
}
