public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    //Metodo que retorna uma String para imprimir um texto.
    @Override
    public String imprimirExtrato() {
        String texto = " ==== Extrato Conta Poupança ==== \n \n" +
                super.imprimirDadosBancarios() + "\n" +
                "Status: POUPANÇA \n" +
                super.imprimirInforValares();

        return texto;
    }


}
