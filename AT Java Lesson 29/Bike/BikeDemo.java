package Bike;

public class BikeDemo {

    Bicycle bicycle = new Bicycle();
    GearedBicycle gearedBicycle = new GearedBicycle();

    public void compareBraking() {
        System.out.printf("%n%nBefore pedaling:%n");
        System.out.println("Bicycle speed: " + bicycle.getSpeed());
        System.out.println("Geared Bicycle speed: " + gearedBicycle.getSpeed());

        for (int i = 0; i < 10; i++) {
            bicycle.pedal();
            gearedBicycle.pedal();
        }

        System.out.printf("%n%nAfter pedaling:%n");
        System.out.println("Bicycle speed: " + bicycle.getSpeed());
        System.out.println("Geared Bicycle speed: " + gearedBicycle.getSpeed());

        for (int i = 0; i < 5; i++) {
            bicycle.brake();
            gearedBicycle.brake();
        }

        System.out.printf("%n%nAfter braking:%n");
        System.out.println("Bicycle speed: " + bicycle.getSpeed());
        System.out.println("Geared Bicycle speed: " + gearedBicycle.getSpeed());

        System.out.printf("%n%n)");
    }

    public static void main(String[] args) {
        BikeDemo demo = new BikeDemo();
        demo.compareBraking();
    }
}
