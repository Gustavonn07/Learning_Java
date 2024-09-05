package exercises_sect1;

// 5. Write a method that allows you to pass any number of Strings as parameter inputs without using an array.

public class E5_String_Args {

    public static void printStrings(String... strings) {
        for(String str : strings) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        printStrings("batata", "arroz", "", "aaa");
    }
}
