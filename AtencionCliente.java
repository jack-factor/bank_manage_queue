package TF;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AtencionCliente {

    static Stack<Cliente> pilaClientesAtendidos = new Stack<Cliente>();
    static Queue<Cliente> colaClientesPreferenciales = new LinkedList<Cliente>();
    static Queue<Cliente> colaClientes = new LinkedList<Cliente>();

    public static Cliente registrarCliente(int dni, String tipoOperacion, LinkedList<Cliente> clientes){
        for(Cliente cli: clientes){
            if(dni == cli.getDni()){
                // colocar tipo de atención
                cli.setTipoAtencion(tipoOperacion);
                // colocar en cola
                if (cli.tipoAtencion.equals("preferencial")) {
                    colaClientesPreferenciales.offer(cli);
                    return cli;
                } else {
                    colaClientes.offer(cli);
                    return cli;
                }
            }
        }
        return null;
    }


    public static void obtenerListaClientes(){
        System.out.println("Preferenciales:");
        for(Cliente clientePreferencial: colaClientesPreferenciales){
            System.out.println(clientePreferencial.toString());
        }
        System.out.println("\nClientes:");
        for(Cliente cliente: colaClientes){
            System.out.println(cliente.toString());
        }
    }

    public static Cliente atenderCliente(){
        Cliente clienteAtendido = null;
        if (!colaClientesPreferenciales.isEmpty()) {
            clienteAtendido = colaClientesPreferenciales.poll();
        } else {
            if (!colaClientes.isEmpty()) {
                clienteAtendido =  colaClientes.poll();
            }
        }
        if (clienteAtendido != null) {
            pilaClientesAtendidos.push(clienteAtendido);
        }
        return clienteAtendido;
    }

    public static Stack<Cliente> getPilaClientesAtendidos() {
        return pilaClientesAtendidos;
    }
}
