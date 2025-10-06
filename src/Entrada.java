import java.io.File;

public class Entrada {
    public static void main(String[] args) {
        Operaciones operaciones = new Operaciones();
        //Operaciones
        operaciones.escribirCliente("src/resources/cliente.dat");
        operaciones.escribirPedido("src/resources/pedido.dat");
        operaciones.leerCliente("src/resources/cliente.dat");
        operaciones.leerPedido("src/resources/pedido.dat");
        operaciones.escribirClienteCSV("src/resources/clientecsv.csv");
        operaciones.escribirPedidoCSV("src/resources/pedidocsv");

    }
}
