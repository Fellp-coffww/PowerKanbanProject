package projetointegrador.Model.Entities;

import java.time.LocalDate;

/*
 * Copyright (C) 2023 Fellipe Augusto <fellipe.augusto01@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author Fellipe Augusto <fellipe.augusto01@gmail.com>
 * @date 08/11/2023
 * @brief Class Ação
 */

// Declaração da classe Ação que implementa a interface Default
public class Acao {

    // Atributos privados da classe
    private LocalDate dataDeInicio;    // Data de início da ação
    private LocalDate dataDeTermino;   // Data de término da ação
    private int percentual;            // Percentual da ação
    private String nome;               // Nome da ação
    private int idx;                   // Indice da lista

    private String descricao;

    private String departamento;

    private String Responsavel;

    private boolean atrasao;

    // Construtor para inicializar uma Ação com parâmetros específicos
    public Acao(LocalDate dataDeInicio, LocalDate dataDeTermino, String nome, String departamento , String responsavel) {
        this.dataDeInicio = dataDeInicio;    // Inicializa a data de início com o valor fornecido
        this.dataDeTermino = dataDeTermino;  // Inicializa a data de término com o valor fornecido
        this.nome = nome;                    // Inicializa o nome com o valor fornecido
        this.departamento = departamento;
        this.Responsavel = responsavel;
    }
    // Construtor vazio
    public Acao() {

    }

    public void editObject() {
        // Implementação para editar um objeto (não especificado no código)
    }

    // Método para atualizar o percentual baseado nas datas de início e término

    public int atualizaPercentualPorData() {

        if (dataDeTermino.getDayOfMonth() - dataDeInicio.getDayOfMonth() != 0) {

            return (LocalDate.now().getDayOfMonth() - dataDeInicio.getDayOfMonth() * 100) /
                    (dataDeTermino.getDayOfMonth() - dataDeInicio.getDayOfMonth());

        } else
            return 100;

        }

    // Método para atualizar o percentual manualmente com um valor fornecido

    public void atualizaPercentualManual(int percentual) {
        this.percentual = percentual;  // Atualiza o percentual com o valor fornecido
    }

    // Métodos getters e setters para acessar e modificar os atributos

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(LocalDate dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(LocalDate dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    public int getPercentual() {
        return percentual;
    }

    public void setPercentual(int percentual) {
        this.percentual = percentual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String toString(){
        return "Nome: " + this.nome + " Data de inicio: " + this.dataDeInicio + " Data de termino: " + this.dataDeTermino + " Departamento: " + this.departamento;
    }
    public String retornaStringFim(){
        String temp = this.dataDeTermino.getDayOfMonth()+"/"+this.dataDeTermino.getMonthValue()+"/"+this.dataDeTermino.getYear();
        return temp;
    }

    public String retornaStringInicio(){
        String temp = this.dataDeInicio.getDayOfMonth()+"/"+this.dataDeInicio.getMonthValue()+"/"+this.dataDeInicio.getYear();
        return temp;
    }
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getResponsavel() {
        return Responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.Responsavel = responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getAtrasao() {
        return atrasao;
    }

    public void setAtrasao(boolean atrasao) {
        this.atrasao = atrasao;
    }
}



