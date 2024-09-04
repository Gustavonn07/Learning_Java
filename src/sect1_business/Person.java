package sect1_business;

// import sect1_business.business.Company;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String middleName;
    public String lastName;
    protected LocalDate dob;
    public static final double PI = 3.14;
    public static int[] nums = initNums();

    Person(String middleName) {
        this.middleName = middleName;
    }

    // Não é muito legivel, mas funciona como inicializador estático
    //    static {
    //        nums = new int[5];
    //        nums[0] = 3;
    //        nums[1] = 3;
    //        nums[2] = 3;
    //        nums[3] = 3;
    //        nums[4] = 3;
    //
    //        System.out.println(nums[0]);
    //    }

    // Melhor abordagem:
    public static int[] initNums() {
        int[] nums = new int[5];
        nums[0] = 3;
        nums[1] = 3;
        nums[2] = 3;
        nums[3] = 3;
        nums[4] = 3;

        return nums;
    }

    public void sayHello() {
        System.out.println("Hello");
        System.out.println(this.middleName);
    }

    public static void saySomething(String text) {
        System.out.println(text);
    }

    public int sayYearBirthday(int year, int thisYear) {
        return thisYear - year;
    }

    public char getMiddleInitial() {
        final String MIDDLE_NAME = "Nepomuceno";
        return MIDDLE_NAME.charAt(0);
    }

    public void test(int a, int b, String[] words) {
        System.out.println(words[0]);
        System.out.println(words[1]);
    }

    // varargs precisam ficar no fim de params
    // varargs funcionam como arrays, então é uma maneira simplificada de se criar uma:
    public void test2(int a, int b, String... words) {
        System.out.println(words[0]);
        System.out.println(words[1]);
    }

    public static void main(String[] args) {
        Person gustavo = new Person("Nepomuceno");
        gustavo.sayHello();

        System.out.println(gustavo.getMiddleInitial());

        gustavo.test(12, 22, new String[] {"batata", "feijao", "arroz"});
        gustavo.test2(19, 18, "lutar", "lular", "bolsonarar");

        System.out.println(args.length);
        System.out.println(PI);
    }

    /* private final String FIANCE = "Fernanda";
    private final double PI_2N = 3.14;
    private String firstName = "Gustavo";
    private byte age;
    private long id;
    private char nameInitial = 'G';
    static Company company = new Company();
    private NewAgency newAgency;

    public void myTestMethod() {
        // Usa-se var quando não se sabe a tipagem da variavel, dando mais flexibilidade. (apenas para variaveis locais)
        var age = 19;
        var name = "Lucas";
    }

    public static void main(String[] args) {
        System.out.println(company);
    } */
}
