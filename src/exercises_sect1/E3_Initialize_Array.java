package exercises_sect1;

//    3. Create an array and initialize it with numbers, 1-10

public class E3_Initialize_Array {
    static int[] numbers = new int[10];

    // Funcionaria:
    // static {
    //     for(int i = 0; i < 10; i++) {
    //         numbers[i] = i + 1;
    //     }
    // }

    static private void initializeArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public static void main(String[] args) {
        initializeArray(numbers);
        System.out.println(numbers.length);
        System.out.println(numbers[1]);
    }
}
