public abstract class Conta implements IConta {
    protected int agencia;
    protected String numeroConta;
    protected double saldo;
    protected Cliente cliente;
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = formatConta();
        this.cliente = cliente;
    }

    @Override
    public void sacarDinheiro(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositarDinheiro(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferirDinheiro(double valor, Conta contaDestino) {
        this.sacarDinheiro(valor);
        contaDestino.depositarDinheiro(valor);

    }

    public int getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirDadosConta(){
        System.out.printf("Titular: %s%n" +
                "Agência: %d%n" +
                "Número da conta: %s%n" +
                "Saldo: %.2f%n", this.cliente.getNomeCliente(), this.agencia, this.numeroConta, this.saldo);
    }

    protected String formatConta() {
        String nc = String.valueOf(String.format("%09d", SEQUENCIAL));
        SEQUENCIAL++;
        return nc.substring(0,3)+"."+nc.substring(3,6)+"."+nc.substring(6,9);
    }



}
