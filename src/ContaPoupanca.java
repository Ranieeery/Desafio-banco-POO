import javax.swing.*;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        JOptionPane.showMessageDialog(null, " ---* Extrato conta poupança *---");
        super.imprimirDadosConta();
    }
}
