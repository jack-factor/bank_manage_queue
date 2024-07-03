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


    public static void ordenamientoSeleccionClienteTiempo(){
        Stack<Cliente> pilaCliente = pilaClientesAtendidos;
        LinkedList<Cliente> listaClientes = new LinkedList<Cliente>(pilaCliente);

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

    public static void ordenamientoBurbujaClienteNombre(){
        Stack<Cliente> pilaCliente = pilaClientesAtendidos;
        LinkedList<Cliente> listaClientes = new LinkedList<Cliente>(pilaCliente);

        int i = 0;
        int j = 0;
        for (i=0; i< listaClientes.size()-1; i++){
            for (j=0; j<listaClientes.size()-1; j++){
                if (listaClientes.get(j+1).nombre.compareTo(listaClientes.get(j).nombre) < 0)
                    intercambioCliente(listaClientes, j, j+1);
            }
        }
        System.out.println("Ordenamiento burbuja");
        for(Cliente item: listaClientes){
            System.out.println(item.toString());
        }
    }

    public static void obtenerRecurisivoElTotalTiempoXTipoAtencion(String [] listaAtencion, int index){
        if (index >= listaAtencion.length){
            return;
        }
        // segunda recursivdad
        int total = calcularRecursivoTotalTiempo(listaAtencion[index], 0);
        System.out.println(listaAtencion[index]);
        System.out.println(total);
        // primera recursividad
        obtenerRecurisivoElTotalTiempoXTipoAtencion(listaAtencion, index + 1);

    }


    public static int calcularRecursivoTotalTiempo(String tipoAtencion, int index){
        if (index >= pilaClientesAtendidos.size()){
            return 0;
        }
        Cliente cliente = pilaClientesAtendidos.get(index);
        int tiempo = 0;
        if (cliente.getTipoAtencion().equals(tipoAtencion)) {
            tiempo = cliente.getTiempoAtencion();
        }
        // Llamada recursiva para el siguiente cliente
        return tiempo + calcularRecursivoTotalTiempo(tipoAtencion, index + 1);
    }


    private static void intercambioCliente(LinkedList<Cliente> listaCliente, int i, int j){
        Cliente temporal = listaCliente.get(i);
        listaCliente.set(i, listaCliente.get(j));
        listaCliente.set(j, temporal);
    }


    public static void buscarTodasEstructuraDatos(String nombre, String apellido) {

        LinkedList<Cliente> lista1 = new LinkedList<Cliente>(colaClientes);
        LinkedList<Cliente> lista2 = new LinkedList<Cliente>(colaClientesPreferenciales);
        LinkedList<Cliente> lista3 = new LinkedList<Cliente>(pilaClientesAtendidos);

        Cliente clienteCola = buscarPorNombreEnCola(lista1, nombre, apellido);
        Cliente clientePreferencial = buscarPorNombreEnCola(lista2, nombre, apellido);
        Cliente clienteAtendido = buscarPorNombreEnCola(lista3, nombre, apellido);

        if(clienteCola != null){
            System.out.println("El cliente se encuentra en espera de atención");
            System.out.println(clienteCola.toString());
        } else if (clientePreferencial != null) {
            System.out.println("El cliente se encuentra en espera de atención preferencial");
            System.out.println(clientePreferencial.toString());
        } else if (clienteAtendido != null) {
            System.out.println("El cliente se encuentra en la lista de atendidos");
            System.out.println(clienteAtendido.toString());
        } else {
            System.out.println("Cliente no encontrado");
        }


    }
    public static Cliente buscarPorNombreEnCola(LinkedList<Cliente> listaClientes, String nombre, String apellido) {
        //busqueda
        boolean estado = false;
        int posicion_inicial = 1;
        int posicion_final = listaClientes.size()-1;
        while (posicion_inicial <= posicion_final){
            int posicion_medio = (int)Math.floor((posicion_inicial + posicion_final)/2);
            String elemento_nombre = listaClientes.get(posicion_medio).getNombre();
            String elemento_apellido = listaClientes.get(posicion_medio).getApellido();
            if (elemento_nombre.equals(nombre) && elemento_apellido.equals(apellido)) {
                return listaClientes.get(posicion_medio);
            }
            else{
                if (elemento_nombre.compareTo(nombre) > 0 && elemento_apellido.compareTo(apellido) > 0)
                    posicion_inicial = posicion_medio + 1;
                else
                    posicion_final = posicion_medio - 1;
            }
        }
        if (!estado){
            return null;
        }
        return null;
    }


}
