package exercises_sect1;

//  4. Try creating an array to represent the tic-tac-toe board.
//  4.1. How would you access the value in the bottom right square with Java code?

import java.lang.reflect.Array;

public class E4_Matriz {
    static final int[][] TIC_TAC_TOE = {
            {0, 1, 0},
            {1, 0, 1},
            {1, 1, 0}
    };

    public static void main(String[] args) {
        System.out.println(TIC_TAC_TOE[TIC_TAC_TOE.length - 1][TIC_TAC_TOE.length - 1]);
    }
}
