import javax.swing.*;
import java.awt.*;
import java.nio.channels.ClosedByInterruptException;

public class Main {
    public static void main(String[] args) {

        ServicosBancarios servicos = new ServicosBancarios();
        //Chama o metodo para iniciar o programa e fazer o cadastro do Cliente.
        servicos.painelCliente();
    }
}
