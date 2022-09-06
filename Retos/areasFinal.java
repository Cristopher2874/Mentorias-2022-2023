package Retos;
import java.util.*; //import para entradas del usuario

public class areasFinal {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in); //objeto scanner

        System.out.println("Ingresa el valor de cada diámetro separados por un espacio"); //pedimos los datos

        double d1 = in.nextDouble(); //variables tipo double que reciben cada diametro
        double d2 = in.nextDouble();
        double d3 = in.nextDouble();

        d1 = Math.abs(d1); //usar el metodo math para la funcion .abs
        d2 = Math.abs(d2); //la funcion te devuleve el valor absoluto de un numero
        d3 = Math.abs(d3); //con esa funcion puedes cambiar negativos a positivos

        double rad1 = d1 / 2; //obtener el radio dependiendo de cada diametro
        double rad2 = d2 / 2;
        double rad3 = d3 / 2;

        //obtener el area de cada circulo
        double area1 = Math.PI * (Math.pow(rad1, 2)); //Math.PI es el valor de la constante que se multiplica
        double area2 = Math.PI * (Math.pow(rad2, 2)); //Math.pow eleva el radio al cuadrado
        double area3 = Math.PI * (Math.pow(rad3, 2)); //es una funcion para potencias, primero la base y luego la potencia

        //se imprime el area de cada diametro sin ordenar. Usar concatenacion para el enunciado
        System.out.println("Las áreas de cada diámetro son: " +
        area1 + " del diámetro 1, " + area2 + " del diámetro 2, " + area3 + " del diámetro 3" 
        );

        //declaracion de variables para ordenar los valores en orden
        double maxValue = 0;
        double minValue = 0;
        double midValue = 0;

        //condicionales para revisar cual es el area mayor.
        if(area1 > area2 && area1 > area3){
            maxValue = area1;
        }
        else if(area2 > area1 && area2 > area3){
            maxValue = area2;
        }
        else if(area3 > area1 && area3 > area2){
            maxValue = area3;
        }
        //cada caso compara un area con las otras dos usando and (&&), cuando encuentra el area
        //iguala la variable de maxValue al valor de esa area

        //condicionales para revisar cual es el mid value y el min value
        if(area1 != maxValue){ //primero revisa que el area que va a comparar no sea la mayor
            if(area1 > area2){ //compara con la primera area para ver si es mid o min value
                midValue = area1; //si el area es mayor a una pero no es el maxValue, entonces es el area 
                minValue = area2; //es el midValue y la que sobra es el minimo
            }
            else if(area1 > area3){ //el mismo proceso pero con la segunda area que no hemos comparado
                midValue = area1;
                midValue = area3;
            }
            else{
                minValue = area1; //si no es mayor a ninguna entonces es el menor valor
            }
        }

        if(area2 != maxValue){ //repetir el mismo proceso de antes para el area 2 y 3
            if(area2 > area1){
                midValue = area2;
                minValue = area1;
            }
            else if(area2 > area3){
                midValue = area2;
                midValue = area3;
            }
            else{
                minValue = area2;
            }
        }

        if(area3 != maxValue){
            if(area3 > area1){
                midValue = area3;
                minValue = area1;
            }
            else if(area3 > area2){
                midValue = area3;
                midValue = area2;
            }
            else{
                minValue = area3;
            }
        }
        //al final del proceso tenemos el valor de minValue asegurado 

        //condicionales para obtener el valor de midValue
        if(area1 != maxValue && area1 != minValue) midValue = area1; //vemos si el area es max o min
        if(area2 != maxValue && area2 != minValue) midValue = area2; //en caso de que no sea ninguna de las dos
        if(area3 != maxValue && area3 != minValue) midValue = area3; //se asigna el valor de midValue

        //aqui se imprimen las areas en orden de valor, menor a mayor
        System.out.println("Las áreas de los círculos ordenadas de menor a mayor son: " +
            minValue + ", " + midValue + ", " + maxValue
        );

        //con el operador de modulo revisamos que el residuo del diametro sea 0
        if(d1 % 6 == 0) System.out.println("El diámetro 1 es múltiplo de 6"); //si al dividir por 6 el diametro, el residuo de la operacion es 0, entonces el diametro es multiplo de 6
        else if(d1 % 7 == 0) System.out.println("El diámetro 1 es múltiplo de 7"); //mismo proceso para el 7
        else if(d1 % 13 == 0) System.out.println("El diámetro 1 es múltiplo de 13"); //mismo proceso para 13
        //en esta parte imprimimos el mensaje de multiplo solo si se cumple la condicion        

        //repetimos el proceso para cada diametro y terminamos
        if(d2 % 6 == 0) System.out.println("El diámetro 2 es múltiplo de 6");
        else if(d2 % 7 == 0) System.out.println("El diámetro 2 es múltiplo de 7");
        else if(d2 % 13 == 0) System.out.println("El diámetro 2 es múltiplo de 13");
        
        if(d3 % 6 == 0) System.out.println("El diámetro 3 es múltiplo de 6");
        else if(d3 % 7 == 0) System.out.println("El diámetro 3 es múltiplo de 7");
        else if(d3 % 13 == 0) System.out.println("El diámetro 3 es múltiplo de 13");
    }
}
