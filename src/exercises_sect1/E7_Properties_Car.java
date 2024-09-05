package exercises_sect1;

// 7. Model a Car, create an instance of it, pass it to System.out.println() so that its properties will be printed.

public class E7_Properties_Car {
    private String model;
    private String plate;
    private String color;
    private int year;

    E7_Properties_Car (
        String model,
        String plate,
        String color,
        int year
    ) {
        this.model = model;
        this.plate = plate;
        this.color = color;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car { " +
                "model: " + this.model + ", " +
                "plate: " + this.plate + ", " +
                "color: " + this.color + ", " +
                "year: " + this.year + ", " +
                " }";
    }
}

class Main {

    public static void main(String[] args) {
        E7_Properties_Car car = new E7_Properties_Car("modelo", "placa", "cor", 2005);
        System.out.println(car);
    }
}
