package Mentorías;
import java.util.Scanner; //librería para leer entradas en java

public class operadoresFinal {
    public static void main(String[] args){
        int num1 = 4;       
        int num2 = 5;

        final double pi = 3.1416; //declaración de constante en java 

        int suma = num1 + num2; //operación de suma
        int resta = num1 - num2; //operación de resta
        int multiplicacion = num1 * num2; //operación de multiplicación
        int division = num1 / num2; //operación para división
        int modulo = num1 % num2; //operación para módulo 

        Scanner entrada = new Scanner(System.in); //declaración del objeto entrada de tipo scaner
     
        System.out.println("ingresa una palabra");
        String palabras = entrada.nextLine(); //lectura de entrada de texto que se guarda en varibale palabras

        System.out.println("ingresa un número");
        int numeros = entrada.nextInt(); //lectura de entrada entera que se guarda en variable números

        System.out.println("ingresa un decimal");
        double decimals = entrada.nextDouble(); //lectura de entrada decimal que se guarda en varibale decimals

        System.out.println("Aquí hay una operación: " + (multiplicacion + resta) ); //salida a terminal
    }
}
