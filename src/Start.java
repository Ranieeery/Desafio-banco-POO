import javax.swing.*;

public class Start extends Banco {
    public void menu() {
        iniciacao();

    }

    private void iniciacao() {
        do setNomeBanco(JOptionPane.showInputDialog("Insira o nome do Banco"));
        while (getNomeBanco().equals(""));
        Cliente cliente = new Cliente();
        do cliente.setNomeCliente(JOptionPane.showInputDialog("Insira o seu nome"));
        while (cliente.getNomeCliente().equals(""));
        JOptionPane.showMessageDialog(null,
                String.format("Bem vindo ao Banco %s, %s",
                        getNomeBanco(), cliente.getNomeCliente()));

        int option = JOptionPane.showOptionDialog(null,
                "Bem vindo " + cliente.getNomeCliente() + ", qual operação gostaria de realizar?",
                "Página inicial: Banco " + getNomeBanco(),
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opcoesBanco, opcoesBanco[4]);
        operacoes(option);
    }

    private void operacoes(int option) {
        switch (option){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: System.exit(0);

        }
    }

}

