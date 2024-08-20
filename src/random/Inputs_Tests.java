package random;

import java.util.Scanner;

public class Inputs_Tests {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Qual o seu nome? ");
        String nome = input.nextLine(); // Lê a linha completa

        System.out.println("Qual a sua idade? ");
        byte idade = input.nextByte(); // Lê o próximo número como byte

        input.nextLine(); // Limpa o buffer de entrada após nextByte()

        System.out.println("Qual sua comida favorita? ");
        String comida = input.nextLine(); // Lê a linha completa

        System.out.println("Seu nome é " + nome + " e você tem " + idade + " anos de vida e você gosta de " + comida);

        input.close(); // Fecha o Scanner
    }
}
