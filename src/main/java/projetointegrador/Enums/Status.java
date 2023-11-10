package projetointegrador.Enums;

public enum Status {

    NãoIniciado ("Não iniciado"),
    EmExecucao ("Em execução"),
    Finalizado("Finalizado");

    private String status;

    Status(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
