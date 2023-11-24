package projetointegrador.Model.Entities;

import projetointegrador.Model.Enums.Permissao;

// Classe que representa um usuário
public class User {

    private String name; // Nome do usuário
    private String password; // Senha do usuário
    private Permissao permissao = Permissao.Nulo; // Permissão do usuário
    private String departamento; // Departamento do usuário

    private String email;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;

    }

    // Getters e setters para os atributos do usuário

    // Método getter para obter o nome do usuário
    public String getName() {
        return name;
    }

    // Método setter para definir o nome do usuário
    public void setName(String name) {
        this.name = name;
    }

    // Método getter para obter a senha do usuário
    public String getPassword() {
        return password;
    }

    // Método setter para definir a senha do usuário
    public void setPassword(String password) {
        this.password = password;
    }

    // Método getter para obter a permissão do usuário
    public Permissao getPermissao() {
        return permissao;
    }

    // Método setter para definir a permissão do usuário
    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    // Método getter para obter o departamento do usuário
    public String getDepartamento() {
        return departamento;
    }


    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


