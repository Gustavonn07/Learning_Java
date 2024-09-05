package exercises_sect1;

// 11. . Model a class with data that enumerates (associates with a number) the first names of three
// friends, classmates or coworkers. Make it so that this name data will be shared among all instances of the class.

public class E11_Friends {
    public static final String[] FRIENDS = {
            "Fernanda",
            "Talles",
            "Sousa"
    };

    public static String[] getFriends() {
        return E11_Friends.FRIENDS;
    }

    public static void main(String[] args) {
        E11_Friends p1 = new E11_Friends();
        E11_Friends p2 = new E11_Friends();
        E11_Friends p3 = new E11_Friends();

        System.out.println(p1.getFriends()[0]);
        System.out.println(p1.getFriends()[1]);
        System.out.println(p1.getFriends()[2]);

        System.out.println(p2.getFriends()[0]);
        System.out.println(p2.getFriends()[1]);
        System.out.println(p2.getFriends()[2]);

        System.out.println(p3.getFriends()[0]);
        System.out.println(p3.getFriends()[1]);
        System.out.println(p3.getFriends()[2]);
    }
}
