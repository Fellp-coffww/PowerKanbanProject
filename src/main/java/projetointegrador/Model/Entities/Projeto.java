package projetointegrador.Model.Entities;

import java.time.LocalDate;
import java.util.ArrayList;

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
 * @brief Class Projeto
 */


public  class Projeto  {


    private ArrayList<Atividade> lista = new ArrayList();
    private LocalDate dataDeInicio;

    private LocalDate dataDeTermino;

    private int percentual;

    private  String nome;


    public void addObject(Atividade atividade) {

        lista.add(atividade);

    }

    public ArrayList<Atividade> retornaAtividade(){
        return  this.lista;
    }


    public Projeto(LocalDate dataDeInicio, LocalDate dataDeTermino, String nome) {
        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;
        this.nome = nome;
    }
    public Projeto() {

    }

    public void removeObject() {

    }


    public void editObject() {

    }


    public void atualizaPercentualPorData() {

        this.percentual =
                (LocalDate.now().getDayOfMonth()-dataDeInicio.getDayOfMonth()*100) / (dataDeTermino.getDayOfMonth()- dataDeInicio.getDayOfMonth());

    }


    public void atualizaPercentualManual(int percentual) {
        this.percentual = percentual;

    }

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

    @Override
    public String toString() {
        return this.nome;
    }
}
