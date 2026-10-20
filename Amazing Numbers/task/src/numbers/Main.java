package numbers;

import java.util.ArrayList;
import java.util.Scanner;

import static numbers.NumberProperties.*;


public class Main {
    public static void main(String[] args) {
//        write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        showInstructions();
        while(true){
            System.out.println("Enter a request: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println();
                showInstructions();
                continue;
            }
            String[] partes = input.split("\\s+");

            long primeiroNumero;
            try {
                primeiroNumero = Long.parseLong(partes[0]);
            } catch (NumberFormatException e) {
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                continue;
            }

            if (primeiroNumero == 0) {
                System.out.println("\nGoodbye!");
                break;
            }

            if (primeiroNumero < 0) {
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                continue;
            }

            // Se o usuário digitou apenas 1 número
            if (partes.length == 1) {
                numberProperties(primeiroNumero);
                System.out.println();
                continue;
            }

            // Se o usuário digitou 2 parâmetros
            long quantidade;
            try {
                quantidade = Long.parseLong(partes[1]);
            } catch (NumberFormatException e) {
                System.out.println("\nThe second parameter should be a natural number.\n");
                continue;
            }

            if (quantidade <= 0) {
                System.out.println("\nThe second parameter should be a natural number.\n");
                continue;
            }

            // Exibe a lista sequencial de números
            System.out.println();
            for (long i = 0; i < quantidade; i++) {
                long numAtual = primeiroNumero + i;
                propertiesList(numAtual);
            }
            System.out.println();
        }
        scanner.close();
    }
    public static void numberProperties(long number){
        System.out.printf("Properties of %d\n", number);
        System.out.printf("buzz: %b\n", isBuzzNumbers(number));
        System.out.printf("duck: %b\n", isDuck(number));
        System.out.printf("palindromic: %b\n", isPalindromic(number));
        System.out.printf("gapful: %b\n", isGapful(number));
        System.out.printf("even: %b\n", isEven(number));
        System.out.printf("odd: %b\n", isOdd(number));
    }
    private static void propertiesList(long number) {
        ArrayList<String> properties = new ArrayList<>();
        if (isBuzzNumbers(number)) properties.add("buzz");
        if (isDuck(number)) properties.add("duck");
        if (isPalindromic(number)) properties.add("palindromic");
        if (isGapful(number)) properties.add("gapful");
        if (isEven(number)) properties.add("even");
        if (isOdd(number)) properties.add("odd");

        String propertiesList = String.join(", ", properties);
        System.out.printf("%14d is %s%n", number, propertiesList);
    }
    private static void showInstructions() {
        System.out.println("""
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be processed;
                - separate the parameters with one space;
                - enter 0 to exit.
                """);
    }
}

