package random;

import java.util.Locale;
import java.util.Scanner;

public class IMC_Calculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Insira seu peso: ");
        double weight = input.nextDouble();

        System.out.println("Insira sua altura: ");
        double height = input.nextDouble();
        input.close();

        double imc = weight / Math.pow(height, 2);
        System.out.printf("Seu IMC é de: %.2f%n", imc);
    }
}
