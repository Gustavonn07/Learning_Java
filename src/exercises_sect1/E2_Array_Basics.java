package exercises_sect1;

//  2. Create an array and initialize it with the days of the week.
//  2.1.Use System.out.println() to print:
//  2.1.1.The number of items in the array
//  2.1.2.The 4th day in the array

public class E2_Array_Basics {
    private final static String[] DAYS_OF_WEEK = {
            "Domingo",
            "Segunda",
            "Terça",
            "Quarta",
            "Quinta",
            "Sexta",
            "Sabado"
    };

    public static void main(String... args) {
        System.out.format("Esse é o número de elementos que a array possui: %s", DAYS_OF_WEEK.length);
        System.out.println();
        System.out.format("No quarto dia esse é o nome do dia: %s", DAYS_OF_WEEK[3]);
    }
}
