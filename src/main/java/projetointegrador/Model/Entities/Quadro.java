package projetointegrador.Model.Entities;

import java.util.ArrayList;

public class Quadro {


    private ArrayList<Projeto> lista = new ArrayList();

    public void addObject(Projeto projeto) {
        lista.add(projeto);

    }

    public ArrayList<Projeto> retornaProjeto(){
        return this.lista;
    }

    public void setLista(ArrayList<Projeto> lista) {
        this.lista = lista;
    }
}
