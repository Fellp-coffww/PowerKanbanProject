package projetointegrador.Model.Enums;

public enum Permissao {

    Nulo ("Nulo"),
    Colaborador ("Colaborador"),
    Administrador("Administrador");

    private String permissao;

    Permissao(String permissao){
        this.permissao = permissao;
    }

    public String getPermissao() {
        return permissao;
    }

}
