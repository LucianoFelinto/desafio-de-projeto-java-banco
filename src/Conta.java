public abstract class Conta implements InterfaceConta{

    private static final int AGENCIA_PADRAO = 3040;
    private static int SEQUENCIAL = 10110;
    protected int agencia;
    protected int numConta;
    protected double saldo;

    protected double saldoAnterior;
    protected double debito;
    protected double deposito;
    protected double transferir;

    protected Cliente cliente;

    //Gera um numero para conta corrente e conta poupança.
    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numConta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public Conta() {

    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumConta() {
        return numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    //Ação para sacar um certo valor.
    @Override
    public void sacar(double valor) {
        this.debito = valor;
        this.saldo -=valor;

    }

    //Ação de depositar um certo valor.
    @Override
    public void depositar(double valor) {
        this.deposito = valor;
        this.saldoAnterior = this.saldo;
        this.saldo +=valor;

    }

    //Açao de Tranferir os valores para uma conta.
    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.transferir = valor;
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    //Metodo que retorna uma String para imprimir os textos.
    protected String imprimirInforValares(){

        String saldoAnterior = (String.format("Saldo Anterior: %.2f \n", this.saldoAnterior));
        String deposito = (String.format("Deposito: %.2f \n", this.deposito));
        String debito = (String.format("Debito: -%.2f \n", this.debito));
        String tranferencia = (String.format("Status de Tranferencia: %.2f \n", this.transferir));
        String saldoAtual = (String.format("Saldo: %.2f \n", this.saldo));

        return saldoAnterior + deposito + debito + tranferencia + saldoAtual;
    }

    //Metodo que retorna uma String para imprimir os textos.
    protected String imprimirDadosBancarios(){
        String cliente = (String.format("Nome do Cliente: %s \n" , this.cliente.getNome()));
        String agencia = (String.format("Agencia: %d \n " , this.agencia));
        String numConta = (String.format("Conta: %d \n", this.numConta));

        return cliente + agencia + numConta;
    }
}
