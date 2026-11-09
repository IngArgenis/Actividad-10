import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculadoraExcepciones {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Utilizamos un bloque try para solicitar los datos numericos
        try {
            System.out.println("=== CALCULADORA ===");
            
            System.out.print("Ingresa el primer número: ");
            double numero1 = teclado.nextDouble();

            System.out.print("Ingresa el segundo número: ");
            double numero2 = teclado.nextDouble();

            System.out.print("Ingresa la operación (+, -, *, /): ");
            //Capturamos el primer carácter de lo que escriba el usuario
            char operacion = teclado.next().charAt(0);

            double resultado = 0;

            //Realizamos la operación deseada usando un bloque switch
            switch (operacion) {
                case '+':
                    resultado = numero1 + numero2;
                    break;
                case '-':
                    resultado = numero1 - numero2;
                    break;
                case '*':
                    resultado = numero1 * numero2;
                    break;
                case '/':
                    //Mostrar mensaje si intenta dividir por cero
                    if (numero2 == 0) {
                        throw new ArithmeticException("¡Error! No es posible dividir un número entre cero.");
                    }
                    resultado = numero1 / numero2;
                    break;
                default:
                    //Mostrar mensaje si ingresa una operación inválida
                    throw new IllegalArgumentException("La operación '" + operacion + "' no existe.");
            }

            System.out.println("El resultado es: " + resultado);

        } catch (ArithmeticException e) {
            //Captura la excepción de división por cero
            System.out.println(e.getMessage());
            
        } catch (IllegalArgumentException e) {
            //Captura la excepción de operación inválida
            System.out.println(e.getMessage());
            
        } catch (InputMismatchException e) {
            // Un catch por si se ingresan letras en lugar de números
            System.out.println("Debes ingresar valores numéricos.");
            
        } catch (Exception e) {
            //Captura cualquier otra excepción general inesperada
            System.out.println("Ocurrió un error inesperado: " + e.toString());
            
        } finally {
            //Bloque finally para cerrar el Scanner 
            teclado.close();
        }
    }
}