package interfaz;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner (System.in);
    public static String leerString(String mensaje){
        String nombre;
        System.out.print(mensaje);
        nombre = sc.nextLine();
        while(nombre == null || nombre.trim().isEmpty()){
            System.out.println("Lectura Invalida. Vuelva a Ingresar.");
            System.out.print(mensaje);
            nombre = sc.nextLine();
        }
        /*do{
            System.out.print("Ingrese el nombre (No vacío ni nulo): ");
            nombre = sc.nextLine();
        }while(nombre == null || nombre.trim().isEmpty());*/
        return nombre;
    }

    //leer numero positivo-mayor que algo - menor que algo-leer dentro de un rango
}
