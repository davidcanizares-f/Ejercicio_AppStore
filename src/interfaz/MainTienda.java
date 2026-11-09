package interfaz;

import modelo.AppStore;
import modelo.Juego;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner (System.in);
    private static AppStore tienda = new AppStore();

    public static void main(){
        int opc;
        tienda.inicialiarDatos();
        do{
            menu();
            opc = Integer.parseInt(sc.nextLine());

            switch(opc){
                case 1:{
                    System.out.println("Opcion 1");
                }break;

                case 2:{
                    System.out.println("Opcion 0");
                }break;

                case 3:{
                    System.out.println("Opcion 2");
                }break;

                case 4:{
                    System.out.println("Opcion 3");
                }break;

                case 5:{
                    System.out.println("Opcion 4");
                }break;

                case 6:{
                    System.out.println("Opcion 5");
                }break;

                case 7:{
                    System.out.println("Opcion 6");
                }break;

                default:
                    System.out.println("[!] Opción no válida.");
            }


        }while(opc != 7);
        sc.close();

    }
    public static void menu(){
        System.out.println("********** AppStore UDLA **********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("> Ingrese una opcion: ");
    }
    public static void ingresarJuego(){
        System.out.println("******* Ingreso de datos ********");
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la categoria: ");
        String categoria = sc.nextLine();
        System.out.print("Ingrese el tamanio: ");
        int tamanio = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());
        if(tienda.agregarJuego(new Juego(nombre, categoria, tamanio, precio, licenciasDisponibles))){
            JOptionPane.showMessageDialog(null, "Juego Ingresado con Éxito");
        }else{
            JOptionPane.showMessageDialog(null, "No fue Posible Agregar");
        }
    }
}
