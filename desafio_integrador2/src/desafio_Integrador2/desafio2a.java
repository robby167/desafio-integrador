package desafio_Integrador2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class desafio2a {

    public static void main(String[] args) {
        realizarOperaciones();
    }

    public static void realizarOperaciones() {
        Scanner entrada = new Scanner(System.in);
        char decisionf = 'N';
        boolean flag = false;

        while (!flag) {
            try {
                mostrarMenu();
                int decision = entrada.nextInt();

                if (decision < 1 || decision > 4) {
                    flag = true;
                    throw new ArithmeticException();
                }

                int num1, num2, resultado;
                switch (decision) {
                    case 1:
                        num1 = pedirNumero("primer");
                        num2 = pedirNumero("segundo");
                        resultado = num1 + num2;
                        mostrarResultado(resultado);
                        break;
                    case 2:
                        num1 = pedirNumero("primer");
                        num2 = pedirNumero("segundo");
                        resultado = num1 - num2;
                        mostrarResultado(resultado);
                        break;
                    case 3:
                        num1 = pedirNumero("primer");
                        num2 = pedirNumero("segundo");
                        resultado = num1 * num2;
                        mostrarResultado(resultado);
                        break;
                    case 4:
                        num1 = pedirNumero("primer");
                        if (num1 == 0) {
                            flag = true;
                            throw new ArithmeticException();
                        }
                        num2 = pedirNumero("segundo");
                        if (num2 == 0) {
                            flag = true;
                            throw new ArithmeticException();
                        }
                        resultado = num1 / num2;
                        mostrarResultado(resultado);
                        break;
                }

                System.out.println("¿Desea realizar otra operacion? (S/N)");
                decisionf = entrada.next().charAt(0);

                if (decisionf == 'N') {
                    flag = true;
                }

            } catch (ArithmeticException e) {
                System.out.println("Error: división por cero");
                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: dato no válido");
                flag = true;
            }
        }

        System.out.println("Fin del programa");
    }

    public static void mostrarMenu() {
        System.out.println("Menu");
        System.out.println("Elija qué tipo de operación realizar:");
        System.out.println("Suma(1) Resta(2) Multiplicación(3) División(4)");
    }

    public static int pedirNumero(String ordinal) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba el " + ordinal + " número: ");
        return entrada.nextInt();
    }

    public static void mostrarResultado(int resultado) {
        System.out.println("Resultado: " + resultado);
    }
}
