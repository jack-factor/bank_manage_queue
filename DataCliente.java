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

        dataClientes.add(new Cliente(33333333, "Carlos", "Gomez Fernandez"));
        dataClientes.add(new Cliente(44444444, "Luis", "Mendoza Morales"));
        dataClientes.add(new Cliente(55555555, "Ana", "Ramirez Delgado"));
        dataClientes.add(new Cliente(66666666, "Jorge", "Castro Herrera"));
        dataClientes.add(new Cliente(77777777, "Elena", "Torres Guzman"));
        dataClientes.add(new Cliente(88888888, "Miguel", "Diaz Rojas"));
        dataClientes.add(new Cliente(99999999, "Lucia", "Flores Ruiz"));
        dataClientes.add(new Cliente(10101010, "Pedro", "Garcia Lopez"));
        dataClientes.add(new Cliente(20202020, "Sofia", "Martinez Sanchez"));
        dataClientes.add(new Cliente(30303030, "Daniel", "Jimenez Romero"));
        dataClientes.add(new Cliente(40404040, "Valeria", "Vargas Peña"));
        dataClientes.add(new Cliente(50505050, "Oscar", "Ramos Castillo"));
        dataClientes.add(new Cliente(60606060, "Gabriela", "Ortiz Chavez"));
        dataClientes.add(new Cliente(70707070, "Fernando", "Reyes Villanueva"));
        dataClientes.add(new Cliente(80808080, "Alejandra", "Cruz Marin"));

        dataClientes.add(new Cliente(90909090, "Andrea", "Morales Vega"));
        dataClientes.add(new Cliente(12121212, "Jose", "Navarro Ponce"));
        dataClientes.add(new Cliente(13131313, "Marcos", "Rivera Alvarado"));
        dataClientes.add(new Cliente(14141414, "Raul", "Sanchez Luna"));
        dataClientes.add(new Cliente(15151515, "Patricia", "Gonzales Valverde"));
        dataClientes.add(new Cliente(16161616, "Monica", "Castillo Hidalgo"));
        dataClientes.add(new Cliente(17171717, "Julian", "Diaz Ortiz"));
        dataClientes.add(new Cliente(18181818, "Camila", "Figueroa Lopez"));
        dataClientes.add(new Cliente(19191919, "Enrique", "Soto Ramirez"));
        dataClientes.add(new Cliente(23232323, "Esteban", "Mejia Mendoza"));
        dataClientes.add(new Cliente(24242424, "Gloria", "Vasquez Chavez"));
        dataClientes.add(new Cliente(25252525, "Rafael", "Guzman Paredes"));
        dataClientes.add(new Cliente(26262626, "Isabel", "Leon Torres"));
        dataClientes.add(new Cliente(27272727, "Angel", "Campos Quiroz"));
        dataClientes.add(new Cliente(28282828, "Victor", "Molina Rojas"));
        dataClientes.add(new Cliente(29292929, "Mariana", "Ortega Ruiz"));
        dataClientes.add(new Cliente(31313131, "Nicolas", "Luna Soto"));
        dataClientes.add(new Cliente(32323232, "Karina", "Lozano Carrillo"));
        dataClientes.add(new Cliente(33333333, "Adrian", "Perez Espinoza"));
        dataClientes.add(new Cliente(34343434, "Sara", "Rivas Campos"));
        dataClientes.add(new Cliente(35353535, "Gustavo", "Vargas Campos"));
        dataClientes.add(new Cliente(36363636, "Rosa", "Santos Fernandez"));
        dataClientes.add(new Cliente(37373737, "Antonio", "Arias Cordero"));
        dataClientes.add(new Cliente(38383838, "Laura", "Bravo Ruiz"));
        dataClientes.add(new Cliente(39393939, "Felipe", "Correa Diaz"));
        dataClientes.add(new Cliente(40404040, "Tamara", "Herrera Campos"));
        dataClientes.add(new Cliente(41414141, "Edgar", "Huaman Perez"));
        dataClientes.add(new Cliente(42424242, "Diana", "Paredes Benavides"));
        dataClientes.add(new Cliente(43434343, "Javier", "Mamani Torres"));
        dataClientes.add(new Cliente(44444444, "Jessica", "Llamas Garcia"));
        dataClientes.add(new Cliente(45454545, "Ruben", "Rojas Flores"));
        dataClientes.add(new Cliente(46464646, "Natalia", "Alvarez Torres"));
        dataClientes.add(new Cliente(47474747, "Ines", "Gutierrez Fernandez"));

    }


    public static LinkedList<Cliente> getDataClientes() {
        return dataClientes;
    }



}
