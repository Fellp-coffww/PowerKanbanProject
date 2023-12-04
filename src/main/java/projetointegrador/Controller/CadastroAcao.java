package projetointegrador.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetointegrador.Model.Entities.*;
import projetointegrador.visual.HelloApplication;

import java.time.LocalDate;

// Classe responsável por controlar a interface de cadastro de uma ação
public class CadastroAcao {

    // Objeto Quadro
    private Quadro quadro = new Quadro();

    private int index;

    private int percent;

    // Referências aos elementos da interface gráfica (FXML)

    @FXML
    protected ComboBox comBoxA; // ComboBox para atividades

    @FXML
    protected ComboBox  ComboDep;

    @FXML
    protected ComboBox ComboResp;

    @FXML
    protected DatePicker DataInicio; // Campo de texto para data de início


    @FXML
    protected TextField decription;

    @FXML
    protected DatePicker DataFim; // Campo de texto para data final

    @FXML
    protected TextField tNome; // Campo de texto para nome

    @FXML
    private Button bSave; // Botão de salvar

    @FXML
    private Button BotaoFecharAba;

    private int originAct = 999;

    // Getter e setter para o objeto Quadro
    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }

    // Método para atualizar o ComboBox de projetos
    @FXML
    protected void AtualizaComboBoxP() {
        ObservableList<String> observableListDep;
        observableListDep = FXCollections.observableArrayList(quadro.getDepartamentos());
        ComboDep.setItems(observableListDep);
        ObservableList<User> observableListUser;
        observableListUser = FXCollections.observableArrayList(quadro.getUsers());
        ComboResp.setItems(observableListUser);
    }

    protected void incializa(){
        AtualizaComboBoxP();
        //AtualizaComboBoxA();
    }


    // Método para habilitar o ComboBox de atividades se houver projetos


    // Método para atualizar o ComboBox de atividades com base no projeto selecionado
    @FXML
    protected void AtualizaComboBoxA() {
        ObservableList<Atividade> observableList;
        observableList = FXCollections.observableArrayList(quadro.retornaProjeto().get(index).retornaAtividade());
        comBoxA.setItems(observableList);
    }


    @FXML
    protected void saveAcao(){

        LocalDate dataInicio = DataInicio.getValue();
        LocalDate dataFinal = DataFim.getValue();
        System.out.println(DataInicio.getValue());
        String nome = tNome.getText();
        String descricao = decription.getText();

        if(nome.equals("")){

            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Não é possível uma ação sem nome");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (comBoxA.getSelectionModel().getSelectedItem() == null) {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Selecione uma atividade para cadastrar uma ação");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (dataInicio == null) {

            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Verifique a data de inicio da acao");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
            
        } else if (dataFinal == null) {

            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Verifique a data de finalização da acao");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (dataInicio.isBefore(quadro.retornaProjeto().get(index).retornaAtividade().get(comBoxA.getSelectionModel().getSelectedIndex()).getDataDeInicio())) {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Data de inicio da ação não pode ser menor que a data de inicio da atividade.");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (dataFinal.isAfter(quadro.retornaProjeto().get(index).retornaAtividade().get(comBoxA.getSelectionModel().getSelectedIndex()).getDataDeTermino())) {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Data de finalização da ação não pode ser maior que a data de finalização da atividade.");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ComboResp.getSelectionModel().getSelectedItem() == null) {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Selecione um responsável pela atividade");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if (ComboDep.getSelectionModel().getSelectedItem() == null) {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Selecione um departamento para a ação");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (dataFinal.isBefore(dataInicio)) {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("JanelaErro.fxml"));
                Parent root = loader.load();
                ControllerErro controllerErro = loader.getController();
                controllerErro.initialize("Data de finalização não pode ser antes que a data de inicio ");
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Erro");
                novaJanela.setScene(new Scene(root));
                novaJanela.showAndWait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            String Responsavel = quadro.getUsers().get(ComboResp.getSelectionModel().getSelectedIndex()).getName();
            String Departmamento = quadro.getDepartamentos().get(ComboDep.getSelectionModel().getSelectedIndex());
            Acao acao = new Acao(dataInicio, dataFinal, nome, Responsavel, Departmamento);
            acao.setDescricao(descricao);

            if (originAct  == 999) {
                quadro.retornaProjeto().get(index).retornaAtividade().get(comBoxA.getSelectionModel().getSelectedIndex()).
                        addObject(acao);

            }
            else {
                quadro.retornaProjeto().get(index).retornaAtividade().get(comBoxA.getSelectionModel().getSelectedIndex()).retornaAcao().remove(originAct);
                quadro.retornaProjeto().get(index).retornaAtividade().get(comBoxA.getSelectionModel().getSelectedIndex()).
                        addObject(originAct, acao);

            }
            Stage stage = (Stage) bSave.getScene().getWindow();
            stage.close();
        }
    }
    @FXML
    protected void AttCbdep(){

    }
    @FXML
    protected void AttCbResp(){

    }



    @FXML
    protected void BotaoVoltar(){
        Stage stage = (Stage) BotaoFecharAba.getScene().getWindow();
        stage.close();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getOriginAct() {
        return originAct;
    }

    public void setOriginAct(int originAct) {
        this.originAct = originAct;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
