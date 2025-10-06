import model.Cliente;
import model.Pedido;

import java.io.*;
import java.util.ArrayList;

public class Operaciones {

    public void escribirCliente(String path) {
        //Crea un nuevo objeto Cliente y lo añade al archivo cliente.dat.
        //Si no existe el archivo, lo crea.

        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            // Escribimos los clientes
            oos.writeObject(new Cliente(1, "Aitor", "aitor123@gmail.com"));
            oos.writeObject(new Cliente(2, "Jorge", "jorge123@gmail.com"));
            oos.writeObject(new Cliente(3, "Mayte", "mayte123@gmail.com"));
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("No tienes permisos de escritura");
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }
    }

    public void escribirPedido(String path) {
        //Crea un nuevo objeto Pedido y lo añade al archivo pedido.dat
        //Si no existe el archivo, lo crea.

        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            //escribimos los objetos
            oos.writeObject(new Pedido(1, 1, "Samsung Galaxy s25", 1));
            oos.writeObject(new Pedido(1, 2, "Saco de comida para gatos", 2));
            oos.writeObject(new Pedido(1, 3, "Camiseta negra", 10));
            oos.writeObject(new Pedido(1, 2, "Arenero grande", 1));
            oos.writeObject(new Pedido(1, 1, "Carcasa bien chula para Galaxy s25", 2));

        } catch (FileNotFoundException e) {
            System.out.printf("\nEl fichero: %s no existe", path);
        } catch (IOException e) {
            System.out.println("No tienes permisos de escritura");
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                System.out.printf("\nError en el cerrado de %s", path);
            }
        }

    }

    public void leerCliente(String path) {
        File file = new File(path);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            //leemos el cliente
            Cliente cliente = (Cliente) ois.readObject();

            System.out.println("Ya tienes el cliente");
            System.out.println(cliente.getNombre());
            System.out.println(cliente.getEmail());

        } catch (FileNotFoundException e) {
            System.out.printf("\nError el archivo %s no se encuentra", path);
        } catch (IOException e) {
            System.out.println("No tienes permisos de lectura");
        } catch (ClassNotFoundException e) {
            System.out.printf("\nError en la lectura del archivo %s", path);
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                System.out.printf("\nError en el cerrado del archivo %s", path);
            }
        }
    }

    public void leerPedido(String path) {
        File file = new File(path);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            //Leemos el pedido
            Pedido pedido = (Pedido) ois.readObject();
            System.out.println(pedido.getProducto());
            System.out.println(pedido.getCantidad());
        } catch (FileNotFoundException e) {
            System.out.printf("\nError el archivo %s no se encuentra", path);
        } catch (IOException e) {
            System.out.println("No tienes permisos de lectura");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en la clase de lectura");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                System.out.printf("\nError en el cerrado del archivo %s", path);
            }
        }
    }

    public void escribirClienteCSV(String path) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente(1, "Aitor", "aitor132@gmail.com"));
        listaClientes.add(new Cliente(2, "Jorge", "jorge123@gmail.com"));
        listaClientes.add(new Cliente(3, "Mayte", "mayte123@gmail.com"));

        File file = new File(path);
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(file, true));
            printWriter.println("id,nombre,email");
            for (Cliente cliente : listaClientes) {
                printWriter.println(cliente);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            printWriter.close();
        }


        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    public void escribirPedidoCSV(String path){
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        listaPedidos.add(new Pedido(1, 1, "Samsung Galaxy s25",1));
        listaPedidos.add(new Pedido(2, 2, "Saco comida para gatos",2));
        listaPedidos.add(new Pedido(3, 3, "Camiseta negra",10));
        listaPedidos.add(new Pedido(4, 2, "Arenero grande",2));
        listaPedidos.add(new Pedido(5, 1, "Carcasa chula",1));

        File file = new File(path);
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(file, true));
            printWriter.println("id,clienteid,producto,cantidad");
            for (Pedido pedido : listaPedidos) {
                printWriter.println(pedido);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            printWriter.close();
        }


        for (Pedido pedido : listaPedidos) {
            System.out.println(pedido);
        }
    }
}
