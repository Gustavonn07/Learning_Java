package random;

import java.text.DecimalFormat;

public class Aritimetic {

    public static void main(String[] args) {
        // expression =  operands & operators
        // operands   =  values, variables, numbers, quantity
        // operators  =  + - * / %

        byte friends = 10;
        friends++;

        System.out.println(friends);

        // Se uma divisão for retornar float mesmo sendo um valor int:
        byte batatas = 10;
        float resultado = (float) batatas / 3;
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println(df.format(resultado));
    }
}
