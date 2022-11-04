
public class Conta implements IConta {
    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = Integer.parseInt(String.format("%06d", 1));

    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
    }

    @Override
    public void sacarDinheiro(double valor) {

    }

    @Override
    public void depositarDinheiro(double valor) {

    }

    @Override
    public void transferirDinheiro(double valor, Conta contaDestino) {

    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }
}
