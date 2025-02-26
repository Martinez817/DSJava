package Bike;

public class GearedBicycle extends Bicycle {
    private int gear;
    private final int MAX_GEAR = 5;

    public int getGear() {
        return gear;
    }

    public void setGear(int newGear) {
        gear = newGear;
    }

    public void shiftUp() {
        gear = gear + 1;
        if (gear > MAX_GEAR) {
            gear = MAX_GEAR;
        }
    }

    public void shiftDown() {
        gear = gear - 1;
        if (gear < 0) {
            gear = 0;
        }
    }
    
    @Override
    public void brake() {
        speed = speed - 2;
        if (speed < 0) {
            speed = 0;
        }
    }
}
