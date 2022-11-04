import java.util.Scanner;

import static javax.swing.JOptionPane.*;

public class Main {
    public static void main(String[] args) {
        Start start = new Start();
        start.menu();

    }
}


class Start extends Banco {
    public void menu() {
        int optionOP = 0;
        iniciacao();
    }

    private void iniciacao() {
        do setNomeBanco(showInputDialog("Insira o nome do Banco"));
        while (getNomeBanco().equals(""));
        Cliente cliente = new Cliente();
        do cliente.setNomeCliente(showInputDialog("Insira o seu nome"));
        while (cliente.getNomeCliente().equals(""));
        showMessageDialog(null,
                String.format("Bem vindo ao Banco %s, %s",
                        getNomeBanco(), cliente.getNomeCliente()));

        int optionAcc = showOptionDialog(null,
                "Bem vindo " + cliente.getNomeCliente() + ", qual tipo de conta gostaria de abrir?",
                "Página inicial: Banco " + getNomeBanco(),
                DEFAULT_OPTION, QUESTION_MESSAGE,
                null, OPCOES_CONTA, OPCOES_CONTA[0]);

        int optionOp = showOptionDialog(null,
                "Bem vindo " + cliente.getNomeCliente() + ", qual operação gostaria de realizar?",
                "Página inicial: Banco " + getNomeBanco(),
                DEFAULT_OPTION, QUESTION_MESSAGE,
                null, OPCOES_BANCO, OPCOES_BANCO[0]);
        System.out.println(optionOp);


        switch (optionAcc) {
            case 2 -> ambos(cliente, optionOp);
            case 1 -> poupanca(cliente, optionOp);
            case 0 -> corrente(cliente, optionOp);
        }
    }

    private void ambos(Cliente cliente, int optionOp) {
        Conta cc = new ContaCorrente(cliente);
        Conta cp = new ContaPoupanca(cliente);

        switch (optionOp) {
            case 0:
                showMessageDialog(null, cc.getSaldo());
                showMessageDialog(null, cp.getSaldo());
                break;
            case 1: //colocar qual conta sacar
                cc.sacarDinheiro(new Scanner(System.in).nextDouble());
                showMessageDialog(null, "O novo saldo da conta corrente é: " + cc.getSaldo());
                showMessageDialog(null, "O novo saldo da conta poupança é: " + cp.getSaldo());
                break;
            case 2: //colocar qual conta depositar
                cc.depositarDinheiro(new Scanner(System.in).nextDouble());
                showMessageDialog(null, "O novo saldo da conta corrente é: " + cc.getSaldo());
                showMessageDialog(null, "O novo saldo da conta poupança é: " + cp.getSaldo());
                break;
            case 3:
                cc.imprimirExtrato();
                cp.imprimirExtrato();

        }
    }

    private void poupanca(Cliente cliente, int optionOp) {
        Conta cp = new ContaPoupanca(cliente);
    }

    private void corrente(Cliente cliente, int optionOp) {
        Conta cc = new ContaPoupanca(cliente);
    }
}

