package Retos;
import java.util.*;

public class heladeriaFinal {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("¿Qué sabor de helado quieres?");

        String pedido = in.nextLine();

        int letras = pedido.length();

        switch(pedido.toLowerCase()){
            case "vainilla":
                System.out.println("Excelente, en un momento tu helado de vainilla");
                break;
            case "chocolate":
                System.out.println("En un momento te damos tu helado de chocolate");
                break;
            case "pistache":
                System.out.println("Buena elección, espera un momento para darte el helado de pistache");
                break;
            default:
                System.out.println("Lo sentimos, no tenemos ese sabor de helado, pero tu sabor tiene " + letras + " letras");
        }
    }
}
