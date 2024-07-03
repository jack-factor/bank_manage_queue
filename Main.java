package TF;

import java.util.Scanner;

public class Main {

    static String[] listaAtencion = {"reclamos", "consultas", "prestamos", "cobranzas", "preferencial"};

    private static void sacarTicket(DataCliente dataClientes, AtencionCliente atencionCliente){
        int dniCliente;
        int indexAtencion;
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingresar número documento");
        dniCliente = scan.nextInt();
        System.out.println("Indique el asunto de la atención:");
        System.out.println("1: reclamos\n2: consultas\n3: prestamos\n4: cobranzas\n5: preferencial");
        indexAtencion = scan.nextInt();
        String tipoAtencion = listaAtencion[indexAtencion -1];
        // valid user
        Cliente clienteRegistrado = atencionCliente.registrarCliente(dniCliente, tipoAtencion, dataClientes.getDataClientes());
        if (clienteRegistrado != null) {
            System.out.println("-----------------------");
            System.out.println("Bienvenid@ "+clienteRegistrado.getNombre()+" lo atenderemos en breve");
            System.out.println(clienteRegistrado.toString());
            System.out.println("-----------------------");
            System.out.println("Lista de espera:\n");
            atencionCliente.obtenerListaClientes();
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    public static void atenderCliente(AtencionCliente atencionCliente) {
        Cliente clienteActual = atencionCliente.obtenerSiguienteClienteEnCola();
        Scanner scan = new Scanner(System.in);
        if(clienteActual != null) {
            System.out.println("El siguiente cliente en hacer atendido es:");
            System.out.println(clienteActual.toString());
            System.out.println("Tiempo de atención: ");
            int tiempoAtencion = scan.nextInt();
            atencionCliente.registrarAtencionCliente(clienteActual, tiempoAtencion);
        }else{
            System.out.println("No hay más clientes en espera de atención");
        }
    }

    public static void clientesAtendidos(AtencionCliente atencionCliente){
        System.out.println("Los clientes atendidos son:" +
                "\n-------------------------------------");
        for(Cliente cliente: atencionCliente.getPilaClientesAtendidos()){
            System.out.println(cliente.toString());
        }

    }

    public static void reportesClientes(AtencionCliente atencionCliente) {
        System.out.println("Nuestras opciones de reportes");
        System.out.println("1: Estado actual de la cola\n2: Usuarios atendidos\n3: Usuarios atendidos de mayor a menor tiempo" +
                "\n4: Usuarios atendidos ordenados alfabeticamente \n5: Buscar usuario por nombre y apellido\n6: Tiempo total por tipo de atención");
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar opción:");
        int opcion = scan.nextInt();
        if(opcion == 1){
            System.out.println("\nLos clientes en espera son:" +
                    "\n-------------------------------------");
            atencionCliente.obtenerListaClientes();
        } else if (opcion == 2) {
            System.out.println("Los clientes atendidos son:" +
                    "\n-------------------------------------");
            for(Cliente cliente: atencionCliente.getPilaClientesAtendidos()){
                System.out.println(cliente.toString());
            }
        } else if (opcion == 3) {
            System.out.println("Lista de clientes ordenado por tiempo de atención:" +
                    "\n-------------------------------------");
            atencionCliente.ordenamientoSeleccionClienteTiempo();
        } else if (opcion == 4) {
            System.out.println("Lista de clientes ordenado por nombre" +
                    "\n-------------------------------------");
            atencionCliente.ordenamientoBurbujaClienteNombre();
        }else if (opcion == 5){
            System.out.println("Buscar usuarios");
            System.out.println("Ingresar Nombre");
            scan.nextLine();
            String nombre = scan.nextLine();
            System.out.println("Ingresar Apellido");
            String apellido = scan.nextLine();
            atencionCliente.buscarTodasEstructuraDatos(nombre, apellido);
        } else if (opcion == 6) {
            System.out.println("Métrica: Tiempo total por tipo de atención");
            atencionCliente.obtenerRecurisivoElTotalTiempoXTipoAtencion(listaAtencion, 0);
        } else {
            System.out.println("Opción incorrecta");
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String otraOperacion = "";
        DataCliente dataClientes = new DataCliente();
        AtencionCliente atencionCliente = new AtencionCliente();
        ManageData manageData = new ManageData();

        System.out.println("SISTEMA BANCARIO \n");
        while (true){
            System.out.println("\nCual de las siguientes operaciones desea realizar:" +
                    "\n---------------------------------------\n" +
                    "a: Sacar un tiquet\nb: Realizar atención\nc: Reporte\nx: Salir");
            otraOperacion = scan.next();
            if(otraOperacion.equals("a")){
                // sacar ticket
                System.out.println("TICKET ___________________________\n");
                sacarTicket(dataClientes, atencionCliente);
            } else if (otraOperacion.equals("b")) {
                System.out.println("ATENCIÓN ___________________________\n");
                atenderCliente(atencionCliente);
            } else if (otraOperacion.equals("c")) {
                System.out.println("REPORTES ___________________________\n");
                reportesClientes(atencionCliente);
            } else if (otraOperacion.equals("x")) {
                System.out.println("Good Bye!");
                return;
            } else if (otraOperacion.equals("hack")){
                manageData.ramdonDataClienteCola(dataClientes, atencionCliente);
            }

        }

    }
}
