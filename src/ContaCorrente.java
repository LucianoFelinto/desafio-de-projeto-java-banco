public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    //Metodo que retorna uma String para imprimir um texto.
    @Override
    public String imprimirExtrato() {
        String texto = " ==== Extrato Conta Corrente ==== \n \n" +
                super.imprimirDadosBancarios() + "\n" +
                "Status: CORRENTE \n" +
                super.imprimirInforValares();

        return texto;
    }
}
