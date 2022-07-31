import javax.swing.*;

public class ServicosBancarios  extends Conta{
    public Cliente cliente = new Cliente();
    //Criação de objeto para corrente e poupança.
    Conta contaCorrente = new ContaCorrente(this.cliente);
    Conta contaPoupanca = new ContaPoupanca(this.cliente);

    //Metodo para cadastro de Cliente.
    void painelCliente(){
        String mensagem = "Digita o seu Nome:";
        //Abre um painel de input para digitar o nome.
        this.cliente.setNome(JOptionPane.showInputDialog(mensagem));

        if (this.cliente.getNome() != null)
            mostraDadosDeEntrada();
        System.exit(0);




    }

    //Metodo para mostrar os dados da conta.
    void mostraDadosDeEntrada(){

        String mensagem = "Nome do Cliente: " + this.cliente.getNome() + "\n" +
                "Numero da Agencia: " + contaCorrente.getAgencia() + "\n" +
                "Conta Corrente: " + contaCorrente.getNumConta() + "\n" +
                "Conta Poupança: " + contaPoupanca.getNumConta() + "\n \n" +
                "Deseja continuar para proxima tela.";

        //Criação de formulario
        JFrame frame = new JFrame();
        int escolha = JOptionPane.showConfirmDialog(frame, mensagem, "TIPO CONTA", JOptionPane.YES_NO_OPTION);

        if(escolha == JOptionPane.YES_OPTION)
        //Metodo para continuar no processo dos serviços do banco.
        painelTipoConta();


        System.exit(0);

    }

    //Metodo para selcionar o tipo da conta.
    public void painelTipoConta() {

        String mensagem = "Você quer entrar em qual conta para usar os serviços? \n" +
                "1 - Conta Corrente \n" +
                "2 - Conta Poupança \n \n";

        int opcao = Integer.parseInt(JOptionPane.showInputDialog(mensagem));

        //Escolha opção para o tipo de conta.
        switch (opcao) {
            case 1: {
                opcaoServicosBancario(contaCorrente);
                System.exit(0);
                break;

            }
            case 2: {
                opcaoServicosBancario(contaPoupanca);
                System.exit(0);
                break;

            }
            default: {
                String texto = "Numero invalido";
                JOptionPane.showMessageDialog(null, texto, "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                mostraDadosDeEntrada();
                System.exit(0);
                break;
            }
        }

        System.exit(0);

    }

    //Metodo para serviços Bancarios.
    void opcaoServicosBancario(Conta conta){

        String messangem = "PAINEL DE SERVIÇOS BANCARIOS \n \n" +
                "Digita o numero da opção desejada: \n" +
                "1 - Mostra Extrato \n" +
                "2 - Depositar \n" +
                "3 - Sacar \n" +
                "4 - Transferência \n" +
                "5 - Sair \n \n";

        int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, messangem));

        switch (opcao){

            //Caso 1 para mostrar o extrato bancario.
            case 1: {
                String texto = conta.imprimirExtrato();
                JOptionPane.showMessageDialog(null, texto);
                mostraDadosDeEntrada();
                System.exit(0);
                break;
            }

            //Caso 2 para fazer o deposito na conta selecionada.
            case 2: {
                conta.depositar(Double.parseDouble(JOptionPane.showInputDialog(null,"Digita um valor")));
                mostraDadosDeEntrada();
                System.exit(0);
                break;
            }

            //Caso 3 tem ação de sacar o valor na conta.
            case 3: {
                conta.sacar(Double.parseDouble(JOptionPane.showInputDialog(null,"Digita um valor")));
                mostraDadosDeEntrada();
                System.exit(0);
                break;
            }

            //Caso 4 faz uma transferência para conta selecionada.
            case 4: {
                servicoTransferencia(conta);
                break;
            }

            // Caso 5 sair do programa, fechar.
            case 5: {
                System.exit(0);
                break;
            }

        }
    System.exit(0);

    }

    //Metodo para serviços para selecionar a conta que vai fazer a transferencia do valor.
    void servicoTransferencia(Conta conta){

        double valor = Double.parseDouble(JOptionPane.showInputDialog(null,"Digita um valor"));
        String texto = "Escolha um tipo de Conta \n" +
                "1 - Conta Corrente \n" +
                "2 - Conta Poupança \n ";

        int escolha = Integer.parseInt((JOptionPane.showInputDialog(null, texto)));

        switch (escolha){

            //Caso 1 transferi para conta corrente
            case 1: {
                conta.transferir(valor, contaCorrente);
                mostraDadosDeEntrada();
                break;
            }

            //Caso 2 transferi para conta poupança
            case 2: {
                conta.transferir(valor,contaPoupanca);
                mostraDadosDeEntrada();
                break;
            }

            // Mensagem de invalido. Fecha o programa.
            default:{
                JOptionPane.showMessageDialog(null,"Numero Invalido!!");
                System.exit(0);
                break;
            }
        }
        System.exit(0);
    }

    @Override
    public String imprimirExtrato() {
        return null;
    }
}
