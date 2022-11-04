import javax.swing.*;

public class ContaCorrente extends Conta{
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        JOptionPane.showMessageDialog(null, " ---* Extrato conta corrente *---");
        super.imprimirDadosConta();
    }
}
