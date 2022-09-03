package Retos;
import java.util.Scanner;

public class tortugaFinal {
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in); //objeto scanner

        System.out.println("¿Cuál es tu animal favorito?");

        String animalElegido = entrada.nextLine(); //guardar el animal en variable

        animalElegido.toLowerCase(); //convertir la entrada a minúsculas con método .toLowerCase()

        if((animalElegido.toLowerCase()).equals("tortuga")){ //usar el método .equals para comparar dos Strings, usar la comparación como condición del if
            System.out.println("Excelente, también es mi animal favorito");
        }
        else {
            System.out.println(animalElegido + " también es un buen animal, pero la tortuga es mi favorito");
        }
    }
}
