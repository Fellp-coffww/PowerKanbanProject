package projetointegrador.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Quadro;

public class CadastroAtividade {


    private Quadro quadro = new Quadro();



    @FXML
    private ComboBox<Projeto> comBox;

    @FXML
    protected void atualizaComboBox(){

        System.out.println(quadro.retornaProjeto().size());
        ObservableList<Projeto> observableList;
        observableList = FXCollections.observableArrayList(quadro.retornaProjeto());
        comBox.setItems(observableList);

    }


    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }


}
