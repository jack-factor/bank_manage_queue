package TF;

import java.util.LinkedList;

public class DataCliente {

    private static LinkedList<Cliente> dataClientes;

    public DataCliente(){
        dataClientes = new LinkedList<Cliente>();
        dataClientes.add(new Cliente(45556666, "Pepe Lucho", "Martinez Maxwell"));
        dataClientes.add(new Cliente(42226666, "Roberto rodriguez", "Martin Valverde"));
        dataClientes.add(new Cliente(43336666, "Heydi", "Tapia Campos"));
        dataClientes.add(new Cliente(44445666, "Marina", "Perez Lucci"));
        dataClientes.add(new Cliente(11111111, "Patricia", "Lopez Rodriguez"));
        dataClientes.add(new Cliente(22222222, "Luz", "Salvador Grados"));
    }


    public static LinkedList<Cliente> getDataClientes() {
        return dataClientes;
    }



}
