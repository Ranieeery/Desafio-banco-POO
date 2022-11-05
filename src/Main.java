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
            case 1:
                int option = showOptionDialog(null,
                        "Sacar em qual conta",
                        "Página saque: Banco " + getNomeBanco(),
                        DEFAULT_OPTION, QUESTION_MESSAGE,
                        null, OPCOES_CONTA, OPCOES_CONTA[0]);

                if (option==0) {
                    cc.sacarDinheiro(new Scanner(System.in).nextDouble());
                    showMessageDialog(null, "O novo saldo da conta corrente é: " + cc.getSaldo());
                } else if (option==1) {
                    cp.sacarDinheiro(new Scanner(System.in).nextDouble());
                    showMessageDialog(null, "O novo saldo da conta poupança é: " + cp.getSaldo());
                } else {
                    cc.sacarDinheiro(new Scanner(System.in).nextDouble());
                    cp.sacarDinheiro(new Scanner(System.in).nextDouble());
                    showMessageDialog(null, "O novo saldo da conta corrente é: " + cc.getSaldo());
                    showMessageDialog(null, "O novo saldo da conta poupança é: " + cp.getSaldo());
                }
                break;
            case 2:
                option = showOptionDialog(null,
                        "Depositar em qual conta",
                        "Página depósito: Banco " + getNomeBanco(),
                        DEFAULT_OPTION, QUESTION_MESSAGE,
                        null, OPCOES_CONTA, OPCOES_CONTA[0]);

                if (option==0) {
                    cc.depositarDinheiro(new Scanner(System.in).nextDouble());
                    showMessageDialog(null, "O novo saldo da conta corrente é: " + cc.getSaldo());
                } else if (option==1) {
                    cp.depositarDinheiro(new Scanner(System.in).nextDouble());
                    showMessageDialog(null, "O novo saldo da conta poupança é: " + cp.getSaldo());
                } else {
                    cc.depositarDinheiro(new Scanner(System.in).nextDouble());
                    cp.depositarDinheiro(new Scanner(System.in).nextDouble());
                    showMessageDialog(null, "O novo saldo da conta corrente é: " + cc.getSaldo());
                    showMessageDialog(null, "O novo saldo da conta poupança é: " + cp.getSaldo());
                }
            case 3:
                cc.imprimirExtrato();
                cp.imprimirExtrato();
            case 4: System.exit(0);
        }
        loopBanco(cliente, 2);
    }

    private void poupanca(Cliente cliente, int optionOp) {
        Conta cp = new ContaPoupanca(cliente);

        switch (optionOp) {
            case 0:
                showMessageDialog(null, cp.getSaldo());
                break;
            case 1:
                cp.sacarDinheiro(showInputDialog());
                showMessageDialog(null, "O novo saldo da conta poupança é: " + cp.getSaldo());
                break;
            case 2:
                cp.depositarDinheiro(new Scanner(System.in).nextDouble());
                showMessageDialog(null, "O novo saldo da conta poupança é: " + cp.getSaldo());
                break;
            case 3:
                cp.imprimirExtrato();
            case 4: System.exit(0);
        }
        loopBanco(cliente, 1);
    }

    private void corrente(Cliente cliente, int optionOp) {
        Conta cc = new ContaCorrente(cliente);

        switch (optionOp) {
            case 0:
                showMessageDialog(null, cc.getSaldo());
                break;
            case 1:
                cc.sacarDinheiro(new Scanner(System.in).nextDouble());
                showMessageDialog(null, "O novo saldo da conta corrente é: " + cc.getSaldo());
                break;
            case 2:
                cc.depositarDinheiro(new Scanner(System.in).nextDouble());
                showMessageDialog(null, "O novo saldo da conta corrente é: " + cc.getSaldo());
                break;
            case 3:
                cc.imprimirExtrato();
            case 4: System.exit(0);
        }
        loopBanco(cliente, 0);
    }

    private void loopBanco(Cliente cliente, int optionAcc) {
        int optionOp = showOptionDialog(null,
                "Bem vindo " + cliente.getNomeCliente() + ", qual operação gostaria de realizar?",
                "Página inicial: Banco " + getNomeBanco(),
                DEFAULT_OPTION, QUESTION_MESSAGE,
                null, OPCOES_BANCO, OPCOES_BANCO[0]);

        switch (optionAcc) {
            case 2 -> ambos(cliente, optionOp);
            case 1 -> poupanca(cliente, optionOp);
            case 0 -> corrente(cliente, optionOp);
        }
    }
}

