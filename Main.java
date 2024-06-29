package TF;

import java.util.Scanner;

public class Main {


    private static void sacarTicket(DataCliente dataClientes, AtencionCliente atencionCliente){
        int dniCliente;
        int indexAtencion;
        Scanner scan = new Scanner(System.in);
        String[] listaAtencion = {"reclamos", "consultas", "prestamos", "cobranzas", "preferencial"};
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
        Cliente clienteActual = atencionCliente.atenderCliente();
        if(clienteActual != null) {
            System.out.println("El siguiente cliente en hacer atendido es:");
            System.out.println(clienteActual.toString());
        }
    }

    public static void clientesAtendidos(AtencionCliente atencionCliente){
        System.out.println("Los clientes atendidos son:" +
                "\n-------------------------------------");
        for(Cliente cliente: atencionCliente.getPilaClientesAtendidos()){
            System.out.println(cliente.toString());
        }
        System.out.println("\nLos clientes en espera son:" +
                "\n-------------------------------------");
        atencionCliente.obtenerListaClientes();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String otraOperacion = "";
        DataCliente dataClientes = new DataCliente();
        AtencionCliente atencionCliente = new AtencionCliente();

        System.out.println("SISTEMA BANCARIO \n");
        while (true){
            System.out.println("\nCual de las siguientes operaciones desea realizar:" +
                    "\n---------------------------------------\n" +
                    "a: sacar un tiquet\nb: realizar atención\nc: Reporte\nx: salir");
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
                clientesAtendidos(atencionCliente);
            } else if (otraOperacion.equals("x")) {
                System.out.println("Good Bye!");
                return;
            }

        }

    }
}
