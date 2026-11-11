package interfaz;

import modelo.AppStore;
import modelo.Juego;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    public static void main() {
        int opc;
        tienda.inicialiarDatos();
        do {
            menu();
            opc = Validacion.leerIntRango("> Ingrese una opción: ", 1, 7);
            //opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1: { //INGRESAR
                    ingresarJuego();
                }
                break;

                case 2: { //MOSTRAR
                    imprimirJuegos();
                }
                break;

                case 3: {// BUSCAR
                    buscarJuego();
                }
                break;

                case 4: { //COMPRAR
                    comprar();
                }
                break;

                case 5: { //VENDER
                    vender();
                }
                break;

                case 6: { //JUEGO MAS VENDIDO
                    mostrarJuegoMasVendido();
                }
                break;

                case 7: { //SALIR
                    System.out.println("GRACIAS POR USAR LA TIENDA! Saliendo...");
                }
                break;

                default:
                    System.out.println("[!] Opción no válida.");
            }


        } while (opc != 7);
        sc.close();

    }

    //------------------------- METODOS ----------------------//

    public static void menu() {
        System.out.println("********** AppStore UDLA **********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
    }

    public static void ingresarJuego() {
        System.out.println("******* Ingreso de datos ********");
        String nombre = Validacion.leerString("Ingrese el Nombre (No vacío ni nulo): ");
        String categoria = Validacion.leerString("Ingrese la Categoría (No vacío ni nulo): ");
        int tamanio = Validacion.leerIntPositivo("Ingrese el tamanio: ");
        double precio = Validacion.leerDoublePositivo("Ingrese el precio: ");
        int licenciasDisponibles = Validacion.leerIntPositivo("Ingrese el stock inicial: ");
        if (tienda.agregarJuego(new Juego(nombre, categoria, tamanio, precio, licenciasDisponibles))) {
            JOptionPane.showMessageDialog(null, "Juego Ingresado con Éxito");
        } else {
            JOptionPane.showMessageDialog(null, "No fue Posible Agregar");
        }
    }

    public static void imprimirJuegos() {
        Juego juegos[] = tienda.getJuegos();
        for (Juego j : juegos) {
            if (j != null) {
                System.out.println(j);
            } else {
                System.out.println("No hay elementos.");
                return;
            }

        }
    }

    public static void buscarJuego(){
        String nombreBuscado = Validacion.leerString("Ingrese el Nombre (No vacío ni nulo): ");
        Juego j = tienda.buscarJuego(nombreBuscado);
        if(j != null){
            System.out.println(j);
        }else{
            System.out.println("No se encontró el juego");
        }
    }

    public static void vender(){
        System.out.println("********* VENDER JUEGO *********");
        String nombre = Validacion.leerString("Ingrese el Nombre (No vacío ni nulo): ");
        int cantidad = Validacion.leerIntPositivo("Ingrese la cantidad a vender: ");
        double totalVenta = tienda.vender(nombre, cantidad);
        if(totalVenta == 0){
            JOptionPane.showMessageDialog(null, "No fue posible realizar la venta.");
            //System.out.println("No fue posible realizar la venta.");
        }else{
            JOptionPane.showMessageDialog(null, "Usted ha vendido " + cantidad + " licencias del juego " + nombre + '\n'+
                                                                        "Ganancia: $" + totalVenta);
            //System.out.println("Usted ha vendido " + cantidad + "licencias del juego " + nombre);
            //System.out.println("Ganancia: $" + totalVenta);
        }
    }

    public static void comprar(){
        System.out.println("********* COMPRAR JUEGO *********");
        String nombre = Validacion.leerString("Ingrese el Nombre (No vacío ni nulo): ");
        int cantidad = Validacion.leerIntPositivo("Ingrese la cantidad a comprar: ");
        if(tienda.comprar(nombre, cantidad)){
            JOptionPane.showMessageDialog(null, "Usted ha comprado " + cantidad + " licencias del juego " + nombre);
        }else{
            JOptionPane.showMessageDialog(null, "No fue posible realizar la compra.");
        }

    }

    public static void mostrarJuegoMasVendido() {
        String juegoMasVendido = tienda.juegoMasVendido();
        if(!juegoMasVendido.equals("")){
            JOptionPane.showMessageDialog(null, "El juego mas vendido es: " + juegoMasVendido);
        }else{
            JOptionPane.showMessageDialog(null, "No hay elementos:");

        }

    }


}
