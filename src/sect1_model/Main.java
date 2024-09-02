package sect1_model;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Person fernanda = new Person(
                LocalDate.of(2005,10,1),
                "Fernanda",
                "Cavalcante"
        );
        Person gustavo = new Person(
                LocalDate.of(2005, 7, 7),
                "Gustavo",
                "Nogueira"
        );
        Dog peralta = new Dog(
                "Peralta",
                LocalDate.of(2021, 7, 19)
        );

        fernanda.setFiance(gustavo);
        fernanda.setPet(peralta);

        System.out.println(fernanda);
    }
}
