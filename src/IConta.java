
public interface IConta {

    void sacarDinheiro(double valor);

    void depositarDinheiro(double valor);

    void transferirDinheiro(double valor, Conta contaDestino);
}
