package projetointegrador.Model.Entities;

import projetointegrador.Model.Enums.Permissao;

public class User {


    private String name;

    private String password;

    private Quadro quadro;

    private Permissao permissao = Permissao.Nulo;

    private String departamento;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
