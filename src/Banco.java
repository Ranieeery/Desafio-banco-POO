import java.util.List;

public class Banco {
    protected final String[] OPCOES_BANCO = {"Verificar saldo", "Saque", "Depósito", "Extrato", "Sair"};
    private String nomeBanco;
    private List<Conta> contas;

    public String getNomeBanco() {
        return nomeBanco;
    }

    protected final String[] OPCOES_CONTA = {"Conta corrente", "Conta poupança", "Ambas"};
    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }
}