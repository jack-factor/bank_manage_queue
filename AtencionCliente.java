package TF;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AtencionCliente {

    static Stack<Cliente> pilaClientesAtendidos = new Stack<Cliente>();
    static Queue<Cliente> colaClientesPreferenciales = new LinkedList<Cliente>();
    static Queue<Cliente> colaClientes = new LinkedList<Cliente>();

    public static Cliente registroSimple(Cliente cliente, String tipoOperacion){
        // colocar tipo de atención
        cliente.setTipoAtencion(tipoOperacion);
        // colocar en cola
        if (tipoOperacion.equals("preferencial")) {
            colaClientesPreferenciales.offer(cliente);
            return cliente;
        } else {
            colaClientes.offer(cliente);
            return cliente;
        }
    }

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

    public static Cliente obtenerSiguienteClienteEnCola(){
        Cliente clienteAtendido = null;
        if (!colaClientesPreferenciales.isEmpty()) {
            clienteAtendido = colaClientesPreferenciales.poll();
        } else {
            if (!colaClientes.isEmpty()) {
                clienteAtendido =  colaClientes.poll();
            }
        }
        return clienteAtendido;
    }

    public static void registrarAtencionCliente(Cliente cliente, int tiempoAtencion){
        cliente.setTiempoAtencion(tiempoAtencion);
        pilaClientesAtendidos.push(cliente);
    }

    public static Stack<Cliente> getPilaClientesAtendidos() {
        return pilaClientesAtendidos;
    }


    public static void ordenamientoSeleccionCliente(){
        Stack<Cliente> pilaCliente = pilaClientesAtendidos;
        LinkedList<Cliente> listaClientes = new LinkedList<Cliente>();
        listaClientes.addAll(pilaCliente);

        int posMenor=0;
        int i=0;
        for (i=0; i<listaClientes.size(); i++){
            posMenor = i;
            for (int j=i+1; j< listaClientes.size(); j++){
                if (listaClientes.get(j).tiempoAtencion > listaClientes.get(posMenor).tiempoAtencion)
                    posMenor = j;
            }

            intercambioCliente(listaClientes, i, posMenor); //posicion actual, posicion del menor elemento
        }

        for(Cliente item: listaClientes){
            System.out.println(item.toString());
        }
    }

    public static void obtenerRecurisivoElTotalTiempoXTipoAtencion(String [] listaAtencion, int index){
            if (index >= listaAtencion.length){
                return;
            }
            int total = 0;
            for (Cliente cliente : pilaClientesAtendidos) {
                if (cliente.getTipoAtencion().equals(listaAtencion[index])) {
                    total += cliente.getTiempoAtencion();
                }
            }
            System.out.println(listaAtencion[index]);
            System.out.println(total);

        obtenerRecurisivoElTotalTiempoXTipoAtencion(listaAtencion, index + 1);

    }


    private static void intercambioCliente(LinkedList<Cliente> listaCliente, int i, int j){
        Cliente temporal = listaCliente.get(i);
        listaCliente.set(i, listaCliente.get(j));
        listaCliente.set(j, temporal);
    }


}
