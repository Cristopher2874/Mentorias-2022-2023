package Mentorías;
public class condicionalesFinal {
    public static void main(String[] args){
        int num1 = 3;
        int num2 = 6;

        /*
         * Tipos de operdores:
         * == para igualdad
         * < para menor que
         * > para mayor que
         * >= para mayor o igual que
         * <= para menor o igual que
         * != para distinto de
         * 
         * && and para poner dos condicinoes necesarias
         * 
         * || para poner dos condiciones opcionales
         */

        //condicional tipo if con una condición y else if

        if(num1 == num2 && num2 > 3){ //condición de que num1 sea igual a num2 y que num2 sea mayor a 3
            num1++; //operador ++ para incrementar la variable en 1
        }
        //la condición es que num1 sea menor a num2 o que num1 sea distinto de 0
        else if(num1 < num2 || num1 != 0){ //agregado de condicional else if para agregar segunda condición
            System.out.println("El número 2 es mayor que el 1");
        }
        else{ //si no se cumple ninguna de las condiciones entra en el else
            num2--; //operador -- para decrementar la variable en 1
        }

        //condicional tipo switch para comparar varios casos

        switch(num1){ //la variable que se va a comparar es num1
            case 1: //case que evalua si num1 es igual a 1
                num1++; //código que se ejecuta si el case se cumple
                break; //break para salir del condicional 
            case 2: //case que evalua si num1 es igual a 2
                System.out.println("hola");
                break;
            case 3: //case que evalua si num1 es igual a 3
                int suma = (num1 + num2);
                break;
            default: //bloque default para cuando ninguna condición se cumpla
                System.out.println("no hay operación");
                break;
        }
    }
}
