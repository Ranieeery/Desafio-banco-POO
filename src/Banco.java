import java.util.List;

public class Banco {
    private String nomeBanco;
    public String getNomeBanco() {
        return nomeBanco;
    }
    private List<Conta> contas;

    protected final String[] opcoesBanco = {"Verificar saldo", "Saque", "Depósito", "Extrato", "Sair"};


    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }
}