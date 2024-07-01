package TF;


public class ManageData {

    public ManageData() {

    }

    public static void ramdonDataClienteCola(DataCliente dataCliente, AtencionCliente atencionCliente) {
        String[] listaAtencion = {"reclamos", "consultas", "prestamos", "cobranzas", "preferencial"};
        int counter = 0;
        for (Cliente cliente : dataCliente.getDataClientes()) {
            int index = (int) (Math.random() * 5);
            atencionCliente.registroSimple(cliente, listaAtencion[index]);
            if(counter == 20) {
                return;
            }
            counter += 1;
        }

    }
}
