package projetointegrador.Model.Entities;

import java.time.LocalDate;
import java.util.ArrayList;

// Importações necessárias

/**
 * Entidade Atividade que representa uma atividade a ser realizada.
 */
public class Atividade  {

    // Lista de Ações associadas a esta atividade
    private ArrayList<Ação> lista = new ArrayList<>();

    // Atributos da atividade
    private LocalDate dataDeInicio;
    private LocalDate dataDeTermino;
    private int percentual;
    private String nome;

    // Construtor da classe Atividade
    public Atividade(LocalDate dataDeInicio, LocalDate dataDeTermino, String nome) {
        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;
        this.nome = nome;
    }

    // Construtor vazio
    public Atividade() {
    }

    public void addObject(Ação acao){
        lista.add(acao);
    }

    public ArrayList<Ação> retornaAcao() {
        return this.lista;
    }
    // Método para remover uma instância de Ação da lista de Ações

    public Ação removeinstanceOfAcao(int idx){
        return lista.get(idx);
    }

    // Métodos da interface Default - não implementados aqui

    // Método para atualizar o percentual com base na data atual e nas datas de início e término da atividade

    public void atualizaPercentualPorData() {
        this.percentual = (LocalDate.now().getDayOfMonth() - dataDeInicio.getDayOfMonth() * 100) / (dataDeTermino.getDayOfMonth() - dataDeInicio.getDayOfMonth());
    }

    // Método para atualizar o percentual manualmente

    public void atualizaPercentualManual(int percentual) {
        this.percentual = percentual;
    }

    // Getters e Setters para os atributos da atividade

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

    @Override
    public String toString() {
        return this.nome;
    }

}
