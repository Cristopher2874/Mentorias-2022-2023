package Retos;
import java.util.*; //importación de clase util para scanner

public class calculadoraFinal {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in); //objeto scanner

        System.out.println("ingrese los valores para hacer la operación");

        double num1 = in.nextDouble(); //variables para guardar los valores del usuario
        double num2 = in.nextDouble();

        System.out.println("pulse 1 para suma, 2 para resta, 3 para producto, 4 para división y 5 para módulo");

        int elección = in.nextInt(); //guardar la elección del usuario en la variable

        switch(elección) //comparar la variable elección con switch
        {
            case 1: //creación de cada case con el valor de la variable
                System.out.println("La suma de tus números es: " + (num1 + num2));
                break; //break necesario para cada case
            case 2: //valor de 2 para variable, etc.
                System.out.println("La diferencia de tus números es: " + (num1 - num2)); //código que se ejecuta en cada case
                break;
            case 3:
                System.out.println("El producto de tus números es: " + (num1 * num2));
                break;
            case 4:
                System.out.println("El cociente de tus números es: " + (num1 / num2));
                break;
            case 5:
                System.out.println("El módulo de tus números es: " + (num2 % num1));
                break;
            default: //bloque de default por si no entra en ninguna de las condiciones anteriores
                System.out.println("el valor no es correcto");
                break;
        }
    }
}
