package projetointegrador.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Quadro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroProjeto {


    private Quadro quadro = new Quadro();

    @FXML
    private Button onbSaveP;

    @FXML
    private TextField tDatainicioP;

    @FXML
    private TextField tDataFinalP;

    @FXML
    private TextField tResponsavelP;

    @FXML
    private TextField tNomeP;

    @FXML
    private Button bSave;

    @FXML
    private void onbSavePClick(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate DatadeInicio = LocalDate.parse(tDatainicioP.getText(), dtf);
        LocalDate DatadeFinalizacao = LocalDate.parse(tDataFinalP.getText(),dtf);
        String nome = tNomeP.getText();
        Projeto projeto = new Projeto(DatadeInicio,DatadeFinalizacao,nome);
        quadro.addObject(projeto);
        System.out.println(projeto);
        System.out.println(quadro.retornaProjeto().size());

    }


    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }



}
