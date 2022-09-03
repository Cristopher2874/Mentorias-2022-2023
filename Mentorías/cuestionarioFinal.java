package Mentorías;
import java.util.Scanner;

public class cuestionarioFinal {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in); //objeto scanner

        System.out.println("Ingresa tu nombre"); //preguntar por el nombre

        String nombreDelUsuario = entrada.nextLine(); //guardar nombre en tipo String

        System.out.println("Ingresa tu edad"); //preguntar edad

        int edadDelUsuario = entrada.nextInt(); //guardar edad en tipo Int

        System.out.println("Hola: " + nombreDelUsuario + " tienes: " + edadDelUsuario + " años"); //imprimir en consola
    }
}
