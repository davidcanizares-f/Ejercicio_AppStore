package interfaz;

import modelo.Juego;
import java.util.Scanner;

public class MainTienda {
    public static void main(){
        Juego j1 = new Juego("FIFA2026", "Deportes", 10, 70, 50);
        System.out.println(j1);
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        do{
            System.out.println("====== APPSTORE =====\n");
            System.out.println("[1]: Visualizar la información detallada de cada juego.");
            System.out.println("[2]: Comprar licencias de un juego.");
            System.out.println("[3]: Vender licencias de un juego.");
            System.out.println("[4]: Consultar el juego más vendido.");
            System.out.println("[5]: Consultar los descuentos aplicados por un volumen de compra.");
            System.out.println("[6]: Salir.");
            System.out.print("> Ingrese una opcion: ");
            opcion = sc.nextInt();
            while(opcion < 1 || opcion > 6){
                System.out.println("Dato invalido.");
                System.out.print("> Ingrese una opcion: ");
                opcion = sc.nextInt();

            }
            switch(opcion){
                case 1:
                    System.out.println("Opcion 1");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }


        }while(opcion != 6);
        sc.close();


    }
}
