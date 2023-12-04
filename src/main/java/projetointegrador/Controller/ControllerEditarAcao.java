
package projetointegrador.Controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.visual.HelloApplication;

import java.io.IOException;

public class ControllerEditarAcao {

    private Quadro quadro;

    private int indexPrj;

    private int indexAtv;

    private int indexAction;


    @FXML
    protected Label nomeAcao;

    @FXML
    protected Slider LsdPercent;


    @FXML
    protected Button onbSaveP;

    @FXML
    protected Label LblPercent;

    @FXML
    protected TextField DescricaoAcao;

    @FXML
    protected Button BotaoFecharAba;


    @FXML
    protected void botaoVoltar(){

        Stage stage = (Stage) BotaoFecharAba.getScene().getWindow();
        stage.close();

    }
    @FXML
    protected void onbSavePClick(){

        quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).setPercentual((int) LsdPercent.getValue());
        quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).setDescricao(DescricaoAcao.getText());
        Stage stage = (Stage) onbSaveP.getScene().getWindow();
        stage.close();

    }

    protected void initialize(){
        nomeAcao.setText(quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).getNome());
        String label = Integer.toString(quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).getPercentual());
        LblPercent.setText(label + "%");
        LsdPercent.setValue(quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).getPercentual());
        DescricaoAcao.setText(quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).getDescricao());
    }

    @FXML
    protected void atualizaPercent(){
        String label = String.format("%.0f",LsdPercent.getValue()) + "%";
        LblPercent.setText(label);
    }

    @FXML
    protected void editarAcao(){

        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("janelaCadastroAçao.fxml"));
            Parent root = loader.load();

            CadastroAcao cadastroAcao = loader.getController();
            cadastroAcao.setQuadro(quadro);
            cadastroAcao.setIndex(indexPrj);
            cadastroAcao.incializa();

            cadastroAcao.tNome.setText(quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).getNome());
            cadastroAcao.decription.setText(quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).getDescricao());
            cadastroAcao.DataInicio.setValue(quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).getDataDeInicio());
            cadastroAcao.DataFim.setValue(quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).getDataDeTermino());
            int comboxDep = 0;
            int comboxUsr = 0;

            for (int n = 0; n< quadro.getDepartamentos().size(); n++){
                if(quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).getDepartamento().equals(quadro.getDepartamentos().get(n))){
                    comboxDep = n;
                }
            }

            for (int n = 0; n< quadro.getUsers().size(); n++){
                if(quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).getResponsavel().equals(quadro.getUsers().get(n))){
                    comboxUsr = n;
                }
            }

            cadastroAcao.AtualizaComboBoxA();
            cadastroAcao.comBoxA.getSelectionModel().select(indexAtv);
            cadastroAcao.ComboDep.getSelectionModel().select(comboxDep);
            cadastroAcao.ComboResp.getSelectionModel().select(comboxUsr);
            cadastroAcao.setOriginAct(indexAction);
            cadastroAcao.setPercent(quadro.retornaProjeto().get(indexPrj).retornaAtividade().get(indexAtv).retornaAcao().get(indexAction).getPercentual());


            Stage novaJanela = new Stage();
            novaJanela.setTitle("Cadastro de Ações");
            novaJanela.setScene(new Scene(root));
            novaJanela.showAndWait();

            quadro = cadastroAcao.getQuadro();
            System.out.println(quadro.retornaProjeto().get(0).retornaAtividade().size());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }

    public int getIndexPrj() {
        return indexPrj;
    }

    public void setIndexPrj(int index) {
        this.indexPrj = index;
    }

    public int getIndexAtv() {
        return indexAtv;
    }

    public void setIndexAtv(int indexAtv) {
        this.indexAtv = indexAtv;
    }

    public int getIndexAction() {
        return indexAction;
    }

    public void setIndexAction(int indexAction) {
        this.indexAction = indexAction;
    }
}
