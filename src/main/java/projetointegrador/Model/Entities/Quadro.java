package projetointegrador.Model.Entities;

import java.util.ArrayList;

// Importações necessárias

/**
 * Classe Quadro responsável por armazenar e manipular uma lista de projetos.
 */
public class Quadro {

    // Lista de projetos associados ao quadro
    private ArrayList<Projeto> lista = new ArrayList<>();

    // Lista de users associados ao quadro
    private ArrayList<User> users = new ArrayList<>();

    // Método para adicionar um projeto à lista de projetos do quadro
    public void addObject(Projeto projeto) {
        lista.add(projeto);
    }

    // Método para retornar a lista de projetos do quadro
    public ArrayList<Projeto> retornaProjeto() {
        return this.lista;
    }

    // Método setter para definir a lista de projetos do quadro
    public void setLista(ArrayList<Projeto> lista) {
        this.lista = lista;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUsers(User user){
        users.add(user);
    }

}
