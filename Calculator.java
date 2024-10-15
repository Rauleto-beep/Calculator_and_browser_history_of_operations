package proyect1;
/**
 *
 * @Rauleto-beep developer
 */
import java.util.Scanner;

public class Calculadora {
    //ALL THE VARIABLES AND println texts have been written in SPANISH
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        double numero1 = 0.0, numero2 = 0.0;
        double suma = 0.0, resta = 0.0, multiplicacion = 0.0, division = 0.0;
        String respuesta_usuario, respuesta_usuario2, historial;
        
        //All the arrays
        String[] operando = new String[100];
        double[] array_num1 = new double[100];
        double[] array_num2 = new double[100];
        int i = 0;

        do {
            //Ask the user for what maths he want to do
            System.out.println("¿Qué quieres hacer?\n - Sumar\n - Restar\n - Multiplicar\n - Dividir\n");
            respuesta_usuario = kb.nextLine();
            
            //Ask the user 2 numbers
            System.out.println("Introduce el primer número: ");
            numero1 = kb.nextDouble();
            System.out.println("Introduce el segundo número: ");
            numero2 = kb.nextDouble();
            //We will introduce them on an array to show a broser history later
            array_num1[i] = numero1;
            array_num2[i] = numero2;

            if (respuesta_usuario.equalsIgnoreCase("sumar")) {
                suma = numero1 + numero2;
                System.out.println("El resultado es " + suma); //The sum 
                operando[i] = " + ";
            } else if (respuesta_usuario.equalsIgnoreCase("restar")) {
                resta = numero1 - numero2;
                System.out.println("El resultado es " + resta); //The minus 
                operando[i] = " - ";
            } else if (respuesta_usuario.equalsIgnoreCase("multiplicar")) {
                multiplicacion = numero1 * numero2;
                System.out.println("El resultado es " + multiplicacion); //Multiply
                operando[i] = " x ";
            } else if (respuesta_usuario.equalsIgnoreCase("dividir")) {
                if (numero2 != 0) {
                    division = numero1 / numero2;
                    System.out.println("El resultado es " + division); //Divide
                    operando[i] = " / ";
                } else {
                    //Can't divide by 0 -> 2/0 = ERROR
                    System.out.println("Error: No se puede dividir entre cero.");
                }
            } else {
                //If the user writes wrong the operation name = ERROR
                System.out.println("Operación no válida.");
            }
            //Ask the user if wants to do another operation
            System.out.println("¿Quieres hacer otra operación? (si/no)");
            /*Necesary to repeat the text entry because when we ask for a String
            * after a Int,when you press for example "2",when you press
            * the ENTER key to send the value,the nextLine(); saves that ENTER
            * and doesn't let you to write something.
            * You can try it to test it that this is right
            */
            respuesta_usuario2 = kb.nextLine();
            respuesta_usuario2 = kb.nextLine();
            //Upgrade so we can save the next number in another array position
            i++; 
        } while (respuesta_usuario2.equalsIgnoreCase("si"));
        //Ask the user if wants to see the browser history
        System.out.println("Quieres ver todos los resultados?\n -Historial\n -Salir");
        historial = kb.nextLine();
        //Check if the answer is the same as we have set
        if(historial.equalsIgnoreCase("historial")){
            for(int y = 0; y < array_num1.length; y++){
                //If the operator +,-,*,/ does not exist it will stop
                if(!(operando[y] == null)){ 
                     System.out.println("Operacion N"+(y+1)+":  " + array_num1[y]+" " + operando[y] +" "+ array_num2[y] + " = " + array_num2[y]);
                }
            }
        }
        else{
            System.out.println("BYE!");
        }
    } 
}

