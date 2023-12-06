package projetointegrador.Model.Entities;

import java.time.LocalDate;
import java.util.ArrayList;

// Importações necessárias

/**
 * Entidade Projeto que representa um projeto a ser realizado.
 */
public class Projeto {

    // Lista de atividades associadas a este projeto
    private ArrayList<Atividade> lista = new ArrayList<>();
    private LocalDate dataDeInicio; // Data de início do projeto
    private LocalDate dataDeTermino; // Data de término do projeto
    private int percentual; // Percentual de conclusão do projeto
    private String nome; // Nome do projeto

    private String empresa;

    // Método para adicionar uma atividade à lista de atividades do projeto
    public void addObject(Atividade atividade) {
        lista.add(atividade);
    }

    // Método para retornar a lista de atividades do projeto
    public ArrayList<Atividade> retornaAtividade() {
        return this.lista;
    }

    // Construtor da classe Projeto
    public Projeto(LocalDate dataDeInicio, LocalDate dataDeTermino, String nome) {
        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;
        this.nome = nome;
    }

    // Construtor vazio
    public Projeto() {}

    // Métodos não implementados (removeObject, editObject)

    // Método para atualizar o percentual com base na data atual e nas datas de início e término do projeto
    public void atualizaPercentualPorData() {
        this.percentual = (LocalDate.now().getDayOfMonth() - dataDeInicio.getDayOfMonth() * 100) /
                (dataDeTermino.getDayOfMonth() - dataDeInicio.getDayOfMonth());
    }

    // Método para atualizar o percentual manualmente
    public void atualizaPercentualManual(int percentual) {
        this.percentual = percentual;
    }

    // Métodos getters e setters para os atributos do projeto

    // Métodos getters e setters para data de início
    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(LocalDate dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    // Métodos getters e setters para data de término
    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(LocalDate dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    // Métodos getters e setters para percentual
    public int getPercentual() {
        return percentual;
    }

    public void setPercentual(int percentual) {
        this.percentual = percentual;
    }

    // Métodos getters e setters para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    // Método toString para obter o nome do projeto como representação de string
    @Override
    public String toString() {
        return this.nome;
    }

    public String retornaStringInicio(){
        String temp = this.dataDeInicio.getDayOfMonth()+"/"+this.dataDeInicio.getMonthValue()+"/"+this.dataDeInicio.getYear();
        return temp;
    }

    public String retornaStringFim(){
        String temp = this.dataDeTermino.getDayOfMonth()+"/"+this.dataDeTermino.getMonthValue()+"/"+this.dataDeTermino.getYear();
        return temp;
    }


}
